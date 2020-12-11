package com.spring.data.repository;

import com.spring.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//always my repository din para malamn ni spring iinject nya
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    //query yung findByUsernameAndPassword kaya gnyn ksi sa entity pwdi mo custom sya pag di kaya
    //pwdi kang mag @Query annotation
    Optional<User> findByUsernameAndPassword(String username, String password);


}
