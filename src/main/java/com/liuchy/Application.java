package com.liuchy;

import com.liuchy.properties.MnsProperties;
import com.liuchy.queue.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by liuchy on 2018/1/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private MnsProperties mnsProperties;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... var1) {
        //MessageListener messageListener = new MessageListener(mnsProperties.getAccessId(), mnsProperties.getAccessKey(), mnsProperties.getEndPoint(), mnsProperties.getPrefix(), mnsProperties.getMessageQueue());
    }
}
