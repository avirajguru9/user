package com.management.user.service;

import com.management.user.model.EmailDetails;

public interface EmailServiceInterface {
	// Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
