package com.blog.app.Service;

import com.blog.app.Entity.Messages;
import com.blog.app.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

    //    @Autowired
    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(Messages message) {
        message.setDatetime(new Date());
        messageRepository.save(message);
        System.out.println("message saved successfully");
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Boolean deleteMessage(int id) {
        messageRepository.deleteById(id);
        System.out.println("message deleted successfuly");
        return true;
    }

    public Boolean updateMessage(Messages messaage) {
        return true;
    }

    public List<Messages> getMessages(Messages message) {
//        messageRepository.findAll();
        List<Messages> messages = (List<Messages>) messageRepository.findAll();

        messages.forEach(msg -> msg.setFromMessage((msg.getFromMessage().equals(message.getFromMessage())) ? "me" : msg.getFromMessage()));

        //    if(msg.getFromMessage().equals(message.getFromMessage())) msg.setFromMessage("me"));
        return messages;


    }
}
