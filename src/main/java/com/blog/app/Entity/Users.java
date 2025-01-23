package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "status")
    String status;
    @Column(name = "email")
    String email;
    @Column(name = "username")
    String username;
    @Column(name = "phone")
    String phone;
    @Column(name = "password")
    String password;
    @Column(name = "role")
    String role;
}
