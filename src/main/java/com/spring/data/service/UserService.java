package com.spring.data.service;

import com.spring.data.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {


    Optional<User> findUsernameAndPassword(String username, String password);
}
