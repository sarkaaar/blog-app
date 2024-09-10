package com.blog.app.Reposotory;

import com.blog.app.Entity.Likes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<Likes, Integer> {

}
