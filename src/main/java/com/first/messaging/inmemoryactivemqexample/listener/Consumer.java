package com.first.messaging.inmemoryactivemqexample.listener;

import lombok.extern.log4j.Log4j2;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void Listener(String message) {
        log.info("received message: {} ", message);
    }
}
