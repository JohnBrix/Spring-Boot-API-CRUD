package com.spring.data.service;

import com.spring.data.domain.Person;
import com.spring.data.domain.User;
import com.spring.data.repository.PersonRepository;
import com.spring.data.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//always my service pag impl
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password);
    }

}
