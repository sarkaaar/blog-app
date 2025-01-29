package com.blog.app.APIs;

import com.blog.app.Entity.Comments;
import com.blog.app.Entity.Messages;
import com.blog.app.Service.CommentService;
import com.blog.app.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("api/message")
@RestController
public class MessagesController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public Boolean addMessages(@RequestBody Messages messages) {
        return messageService.addMessage(messages);
    }

    @PostMapping("/delete")
    public Boolean deleteMessage(@RequestBody Messages messages) {
        return messageService.deleteMessage(messages);
    }

    @PostMapping("/update")
    public Boolean updateMessage(@RequestBody Messages messages) {
        return messageService.updateMessage(messages);
    }

    @PostMapping("/get")
    public List<Messages> getMessages(@RequestBody Messages messages) {
        return messageService.getMessages(messages);
    }

}
