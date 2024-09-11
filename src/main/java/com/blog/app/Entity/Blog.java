package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer postID;
    @Column(name = "title")
    String title;
    @Column(name = "content")
    String content;
    @Column(name = "published_date")
    String publishedDate;
    @Column(name = "user_id")
    String userID;
    @Column(name = "category_id")
    String categoryID;

}
