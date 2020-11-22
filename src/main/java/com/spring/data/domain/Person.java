package com.spring.data.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Table (name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable =  false)
    private Integer id;

    //ito ay para di mag insert or update dahil merong validation dapat di empty

    //@NotEmpty(message = "first name may not be null")
    @Column (name = "first_name",nullable = false)
    private String firstName;

    //    @NotEmpty(message = "last name may not be null")
    @Column(name = "last_name",nullable = false)
    private String lastName;

    //    @NotNull(message = "cannot be null")
    @Column(name = "age",nullable = false)
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
