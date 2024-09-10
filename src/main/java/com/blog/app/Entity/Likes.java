package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "likes")
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    String id;
    @Column(name = "date")
    String CommentDate;
    @Column(name = "blog_id")
    String PostID ;
    @Column(name = "user_id")
    String  UserID ;

}
