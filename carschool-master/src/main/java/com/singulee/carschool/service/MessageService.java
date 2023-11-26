package com.singulee.carschool.service;

import com.singulee.carschool.pojo.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: lishuai
 * Date: 2019/03/19
 * Description:
 * Version: V1.0
 */
@Service
public class MessageService {
    final private MessageMapper messageMapper;

    @Autowired
    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
}
