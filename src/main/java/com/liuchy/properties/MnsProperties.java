package com.liuchy.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by liuchy on 2018/1/17.
 */
@Component
@Data
public class MnsProperties {
    @Value("${mns.endPoint}")
    private String endPoint;

    @Value("${mns.accessId}")
    private String accessId;

    @Value("${mns.accessKey}")
    private String accessKey;

    @Value("${queue.prefix}")
    private String prefix;

    @Value("${messageQueue}")
    private String messageQueue;
}
