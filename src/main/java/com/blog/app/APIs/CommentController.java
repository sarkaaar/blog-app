package com.blog.app.APIs;

import com.blog.app.Entity.Comments;
import com.blog.app.Repository.CommentRepository;
import com.blog.app.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequestMapping("api/comments")
@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("add")
    public Comments addComment(@RequestBody Comments comment) {
        return new Comments();
    }

//    @PostMapping("delete")
//    public Comments deleteComment(@RequestBody Comments comment) {
//        return commentService.deleteComment();
//    }

//    @PostMapping("update")
//    public Comments updateComment(@RequestBody Comments comment) {
//        return commentService.updateComment(String.valueOf(comment));
//    }

    @PostMapping("get")
    public Comments getComments(@RequestBody Comments comment) {
        return new Comments();
    }


}
