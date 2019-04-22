package com.sigh.arthas.demo;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author nerd
 * @date 2019-04-22 15:56
 */
@Component
public class AListener implements MessageListener {
    public void onMessage(Message message) {
        try {
            System.out.println(message.getJMSMessageID());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
