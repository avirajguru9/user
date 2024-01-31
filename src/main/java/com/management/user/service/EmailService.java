package com.management.user.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.management.user.model.EmailDetails;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService implements EmailServiceInterface {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;
	
	@Override
	public String sendSimpleMail(EmailDetails details) {
		try {
			SimpleMailMessage mailMessage = new SimpleMailMessage();
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());
			
			javaMailSender.send(mailMessage);
			
			return "Mail Sent Successfully";
		}catch(Exception e) {
			return "Error while sending mail"+e.getMessage();
		}
	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		
		MimeMessage mineMessage = 
				javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
	
		try {
			mimeMessageHelper = new MimeMessageHelper(mineMessage,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());
			
			FileSystemResource file = 
					new FileSystemResource(
							new File(details.getAttachment())
							);
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mineMessage);
			return "Mail sent Successfully";
		} catch (MessagingException e) {
			return "Error while sending mail"; 
		}
	}

}
