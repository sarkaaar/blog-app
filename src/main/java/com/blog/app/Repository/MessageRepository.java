package com.blog.app.Repository;

import com.blog.app.Entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends CrudRepository<Messages, Integer> {

    @Override
    Optional<Messages> findById(Integer integer);
}
