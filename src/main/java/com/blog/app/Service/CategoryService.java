package com.blog.app.Service;

import com.blog.app.Entity.Blog;
import com.blog.app.Reposotory.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private BlogRepository blogRepository;

    public Boolean updateBlog(Blog blog){

        return true;
    }

    public Boolean deleteBlog(String blog){

        return true;
    }
    public Boolean getAllBlogs(){

        return true;
    }
    public Boolean getBlog(String blog){

        return true;
    }
    public Boolean newBlog(Blog blog){

        return true;
    }


}
