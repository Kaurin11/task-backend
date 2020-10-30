package com.example.demo.service;

import com.example.demo.dto.request.CreateDailyTaskRequest;
import com.example.demo.dto.request.GetTasksByDateRequest;
import com.example.demo.dto.response.DailyTaskResponse;
import com.example.demo.entity.DailyTask;

import java.util.List;

public interface IDailyTaskService {

    DailyTaskResponse getDailyTask (Long id);

    DailyTaskResponse createDailyTask(Long userId,CreateDailyTaskRequest request) throws Exception;

    List<DailyTaskResponse> getAllDailyTask(long userId);

    List<DailyTaskResponse> getAllDailyTaskByDate(long id, GetTasksByDateRequest request);
}
