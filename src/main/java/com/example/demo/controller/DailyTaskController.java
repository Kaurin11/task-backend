package com.example.demo.controller;


import com.example.demo.dto.request.CreateDailyTaskRequest;
import com.example.demo.dto.request.GetTasksByDateRequest;
import com.example.demo.dto.response.DailyTaskResponse;
import com.example.demo.service.IDailyTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users/{userId}/tasks")
public class DailyTaskController {

    private final IDailyTaskService dailyTaskService;

    public DailyTaskController(IDailyTaskService dailyTaskService) {
        this.dailyTaskService = dailyTaskService;
    }

    @GetMapping("/{id}")
    public DailyTaskResponse getDailyTask (@PathVariable Long id) {
        return dailyTaskService.getDailyTask(id);
    }

    @GetMapping
    public List<DailyTaskResponse> getALlDailyTask(@PathVariable long userId){
        return dailyTaskService.getAllDailyTask(userId);
    }

    @PostMapping()
    public DailyTaskResponse createDailyTask(@PathVariable("userId") long userId, @RequestBody CreateDailyTaskRequest request) throws Exception{
        return dailyTaskService.createDailyTask(userId, request);
    }

    @GetMapping("/by-date")
    public List<DailyTaskResponse> getAllDailyTaskByDate(@PathVariable("userId") long userId, GetTasksByDateRequest request){
        return dailyTaskService.getAllDailyTaskByDate(userId, request);
    }
}
