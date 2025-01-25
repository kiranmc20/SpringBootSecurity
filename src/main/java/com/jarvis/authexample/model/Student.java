package com.jarvis.authexample.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Student {

    @Id
    private int id;
    private String username;
    private String password;

}
