package com.liuchy.controller;

import com.liuchy.service.WorkFlowService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liuchy on 2018/1/16.
 */
@RestController
@RequestMapping("/workflow")
public class WorkFlowController {

    @Autowired
    private WorkFlowService workFlowService;

    @RequestMapping(value = "/startprocess/{processDefinitionKey}", method = RequestMethod.POST)
    public String startProcessInstance(@PathVariable("processDefinitionKey") String processDefinitionKey, @RequestParam String assignee) {
        return workFlowService.startProcess(processDefinitionKey, assignee);
    }

    @RequestMapping(value = "/tasks/{assignee}", method = RequestMethod.POST)
    public String getTasks(@PathVariable("assignee") String assignee, @RequestParam String message) {
        workFlowService.messageReceived(message, assignee);
        return "";
    }

    @RequestMapping(value = "/completetask")
    public String completeTask(@RequestParam String id) {
        workFlowService.completeTask(id);
        return "Task with id " + id + " has been completed!";
    }
}
