package com.ricardo.chat.controller;
import com.ricardo.chat.controller.domain.ChatInput;
import com.ricardo.chat.controller.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;


@Controller
public class LiveChatController {

    @MessageMapping("/new-message")
    @SendTo("/topics/livechat")
    public ChatOutput newMessage(ChatInput input){
        return new ChatOutput(HtmlUtils.htmlEscape( input.user()+ ": "+input.message()));

    }


}
