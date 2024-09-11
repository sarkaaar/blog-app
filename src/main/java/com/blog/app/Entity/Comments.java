package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comments")
@Getter
@Setter
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer commentID;
    @Column(name = "content")
    String content;
    @Column(name = "date")
    String commentDate;
    @Column(name = "blog_id")
    String blogID ;
    @Column(name = "user_id")
    String userID ;
}
