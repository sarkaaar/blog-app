package com.blog.app.APIs;

import com.blog.app.Entity.Blog;
import com.blog.app.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*")
@RequestMapping("api/blog")
@RestController
public class BlogController {
    @Autowired
    private  BlogService blogService;

    @PostMapping("new")
    public Boolean newBlog(@RequestBody Blog blog) {
        return blogService.newBlog(blog);
    }

    @PostMapping("delete")
    public Boolean deleteBlog(@RequestBody Blog blog) {
        return blogService.deleteBlog(blog.getPostID());
    }

    @PostMapping("update")
    public Boolean updateBlog(@RequestBody Blog blog) {
        return blogService.updateBlog(blog);
    }

    @PostMapping("get")
    public Boolean getBlog(@RequestBody Integer blog) {
        return blogService.getBlog(blog);
    }

    @PostMapping("get-all")
    public Boolean getAllBlog(@RequestBody Blog blog) {
        return blogService.getAllBlogs();
    }
}
