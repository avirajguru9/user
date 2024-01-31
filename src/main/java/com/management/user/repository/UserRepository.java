package com.management.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
