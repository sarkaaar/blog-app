package com.blog.app.Reposotory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

}
