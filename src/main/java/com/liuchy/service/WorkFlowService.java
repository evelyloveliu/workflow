package com.liuchy.service;

import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.spring.integration.Activiti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by liuchy on 2018/1/19.
 */
@Service
@Slf4j
@Transactional
public class WorkFlowService {
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public String startProcess(String processDefinitionKey, String appId) {
        runtimeService.startProcessInstanceByKey(processDefinitionKey, appId);
        return "Process started";
    }

    public void messageReceived(String message, String appId) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(appId).singleResult();
        Execution execution = runtimeService.createExecutionQuery().processInstanceId(processInstance.getProcessInstanceId()).messageEventSubscriptionName(message).singleResult();
        runtimeService.messageEventReceived(message, execution.getId());
    }

    public void completeTask(String taskId) {
        taskService.complete(taskId);
    }
}
