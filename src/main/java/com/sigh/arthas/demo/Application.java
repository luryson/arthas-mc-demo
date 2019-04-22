package com.sigh.arthas.demo;

import com.aliyun.mns.extended.javamessaging.message.MNSTextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.jms.Message;

/**
 * @author nerd
 * @date 2019-04-22 15:47
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer implements CommandLineRunner {
    @Autowired
    AListener listener;

    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public void run(String... args) throws Exception {
        for (; ; ) {
            Message message = new MNSTextMessage();
            message.setJMSMessageID(UUID.randomUUID().toString());
            listener.onMessage(message);
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
