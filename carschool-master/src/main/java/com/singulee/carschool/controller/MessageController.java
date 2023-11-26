package com.singulee.carschool.controller;

import com.singulee.carschool.pojo.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created with IntelliJ IDEA.
 * User: lishuai
 * Date: 2019/03/19
 * Description:
 * Version: V1.0
 */
@Controller
public class MessageController {
    private MessageMapper messageMapper;

    @Autowired
    public MessageController(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }
}
