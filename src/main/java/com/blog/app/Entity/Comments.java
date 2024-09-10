package com.blog.app.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
