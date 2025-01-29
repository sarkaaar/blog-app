package com.blog.app.Service;

import com.blog.app.Entity.Comments;
import com.blog.app.Entity.Messages;
import com.blog.app.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

//    @Autowired
    @Autowired
    private MessageRepository messageRepository;

    public Boolean addMessage(Messages messaage){
        messageRepository.save(messaage);

        return true;
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
