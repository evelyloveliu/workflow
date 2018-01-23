package com.liuchy.componet;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Created by liuchy on 2018/1/19.
 */
@Component(value = "autoJobDelegate")
public class AutoJobComponet implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println(execution.getEventName() + " start run: " + execution.getProcessBusinessKey());
    }
}
