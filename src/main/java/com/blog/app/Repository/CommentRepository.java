package com.blog.app.Repository;

import com.blog.app.Entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comments, Integer> {
    Comments findByBlogID(String ID);

}
