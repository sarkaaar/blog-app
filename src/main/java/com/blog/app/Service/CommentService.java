package com.blog.app.Service;

import com.blog.app.Reposotory.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.stream.events.Comment;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Boolean addComment(Comment comment){
        return true;
    }

    public Boolean deleteComment(String comment){

        return true;
    }
    public Boolean updateComment(String comment){

        return true;
    }
    public Boolean getAllComments(String connet){

        return true;
    }
}
