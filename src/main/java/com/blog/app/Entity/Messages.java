package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Table(name = "messages")
@Getter
@Setter
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "from_message")
    String fromMessage;
    @Column(name = "toMessage")
    String toMessage;
    @Column(name = "date")
    Date datetime;
    @Column(name = "message")
    String message;
    @Column(name = "status")
    String status;
}