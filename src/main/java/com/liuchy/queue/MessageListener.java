package com.liuchy.queue;

import com.aliyun.mns.client.CloudAccount;
import com.aliyun.mns.client.CloudQueue;
import com.aliyun.mns.client.MNSClient;
import com.aliyun.mns.model.Message;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuchy on 2018/1/17.
 */

@Slf4j
public class MessageListener implements Runnable {
    private String mnsAccessId;
    private String mnsKey;
    private String mnsEndpoint;
    private String queueName;
    private String prefix;

    public MessageListener(String mnsAccessId, String mnsKey, String mnsEndpoint,String prefix ,String queueName) {
        this.mnsAccessId = mnsAccessId;
        this.mnsKey = mnsKey;
        this.mnsEndpoint = mnsEndpoint;
        this.queueName = queueName;
        this.prefix = prefix;
    }


    @Override
    public void run() {
        CloudAccount account = new CloudAccount(mnsAccessId, mnsKey, mnsEndpoint);
        MNSClient client = account.getMNSClient();
        CloudQueue queue = client.getQueueRef(queueName);
        while (true) {
            try {
                Message msg = queue.popMessage();
                if (msg == null) {
                    //PollingWaitSeconds expire
                    //And you could do some work here or do nothing according to your business
                } else {
                    String messageBody = msg.getMessageBodyAsString();
                    //do something
                    queue.deleteMessage(msg.getReceiptHandle());
                }
            } catch (Exception e) {
                log.warn("pop message exeption in queue " + queueName, e);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                continue;
            }
        }
    }
}
