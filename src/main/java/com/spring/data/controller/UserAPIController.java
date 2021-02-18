package com.spring.data.controller;

import com.spring.data.domain.User;
import com.spring.data.exception.Message;
import com.spring.data.exception.UserNotFoundException;
import com.spring.data.service.UserService;
import com.spring.data.util.UriUtil;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins= { "http://localhost:6969", }, maxAge=3000) //host
public class UserAPIController  {

    private final UserService userService;
    public UserAPIController(UserService userService) {
        this.userService = userService;
    }

    //@Request Param pag tag isa
    //pag request Body ay whole object
    @PostMapping
    public ResponseEntity<User> findByUser(@RequestParam String username, @RequestParam String password ){
        System.out.println("my username:"+username);

        return this.userService.findUsernameAndPassword( username, password)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> {
                    List<Message> messages = Arrays.asList(new Message("Invalid Username or Password")); //pag invalid
                    return new UserNotFoundException(HttpStatus.UNAUTHORIZED, messages, UriUtil.path());
                });
        //unauthorized meaning yung user di nag eexist or wala
    }
}
