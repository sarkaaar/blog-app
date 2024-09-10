package com.blog.app.APIs;

import com.blog.app.Entity.Blog;
import com.blog.app.Service.BlogService;
import com.blog.app.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;

@CrossOrigin(origins = "*")
@RequestMapping("api/comments")
@RestController
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("add")
    public Boolean addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }

    @PostMapping("delete")
    public Boolean deleteComment(@RequestBody Comment comment) {
        return commentService.deleteComment(comment.getText());
    }

    @PostMapping("update")
    public Boolean updateComment(@RequestBody Comment comment) {
        return commentService.updateComment(String.valueOf(comment));
    }

    @PostMapping("get")
    public Boolean getComments(@RequestBody Comment comment) {
        return commentService.getAllComments(comment.getText());
    }


}
