package com.blog.app.APIs;

import com.blog.app.Entity.Messages;
import com.blog.app.Entity.Users;
import com.blog.app.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("api/message")
@RestController
public class MessagesController {
    @Autowired
    private MessageService messageService;
    @PostMapping("/new")
    public ResponseEntity<?> addMessages(@RequestBody Messages messages) {
        messageService.addMessage(messages);
        return ResponseEntity.ok("message sent successfully.");
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
