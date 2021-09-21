package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table( name = "users")
public class Student {
    @Id
    @GeneratedValue
    private  int id;
    private String username;
    private String fullname;
    private String password;
    private String role;
}
