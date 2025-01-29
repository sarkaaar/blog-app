package com.blog.app.Repository;

import com.blog.app.Entity.Likes;
import com.blog.app.Entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Messages, Integer> {

}
