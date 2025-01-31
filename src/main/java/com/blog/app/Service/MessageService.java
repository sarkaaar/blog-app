package com.blog.app.Service;

import com.blog.app.Entity.Messages;
import com.blog.app.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {

//    @Autowired
    @Autowired
    private MessageRepository messageRepository;

    public void addMessage(Messages message){
        message.setDatetime(new Date());
        messageRepository.save(message);
        System.out.println("message saved successfully");
    }
    public Boolean deleteMessage(Messages messaage){
        return true;
    }
    public Boolean updateMessage(Messages messaage){
        return true;
    }
    public List<Messages> getMessages(Messages messaage){
//        messageRepository.findAll();

        return (List<Messages>) messageRepository.findAll();
    }
}
