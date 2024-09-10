package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    String commentID;
    @Column(name = "content")
    String  Content;
    @Column(name = "date")
    String CommentDate;
    @Column(name = "blog_id")
    String PostID ;
    @Column(name = "user_id")
    String  UserID ;
}
