package com.spring.data.repository;

import com.spring.data.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, Integer> {


}
