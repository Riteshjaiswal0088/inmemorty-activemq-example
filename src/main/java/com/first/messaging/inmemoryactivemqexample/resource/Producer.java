package com.first.messaging.inmemoryactivemqexample.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

@RestController
@RequestMapping("api/v1/rest/publish")
@RequiredArgsConstructor
public class Producer {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;


    @GetMapping("/{message}")
    public String publish(@PathVariable final String message) {

        jmsTemplate.convertAndSend(queue, message);
        return "published successfully";
    }
}
