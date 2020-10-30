package com.example.demo.service.impl;

import com.example.demo.dto.request.CreateDailyTaskRequest;
import com.example.demo.dto.request.GetTasksByDateRequest;
import com.example.demo.dto.response.DailyTaskResponse;
import com.example.demo.entity.DailyTask;
import com.example.demo.entity.User;
import com.example.demo.repository.IDailyTaskRepository;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IDailyTaskService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DailyTaskService implements IDailyTaskService {

    private final IDailyTaskRepository dailyTaskRepository;

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DailyTaskService(IDailyTaskRepository dailyTaskRepository, IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.dailyTaskRepository = dailyTaskRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public DailyTaskResponse getDailyTask(Long id) {
        Optional<DailyTask> dailyTask = dailyTaskRepository.findById(id);
        return mapDailyTaskToDailyTaskResponse(dailyTask.get());
    }

    @Override
    public DailyTaskResponse createDailyTask(Long userId , CreateDailyTaskRequest request) throws Exception {

        if(dailyTaskRepository.findOneByTitle(request.getTitle()) != null){
            throw new Exception("Already exists.");
        }

        if(userRepository.findUserById(userId) == null){
            throw new Exception("User don't exist.");
        }

        DailyTask dailyTask = new DailyTask();
        dailyTask.setTitle(request.getTitle());
        dailyTask.setHours(request.getHours());
        dailyTask.setDate(request.getDate());
        User user = new User();
        user.setId(userId);
        dailyTask.setUser(user);

        DailyTask savedDailyTask = dailyTaskRepository.save(dailyTask);
        return mapDailyTaskToDailyTaskResponse(savedDailyTask);
    }

    @Override
    public List<DailyTaskResponse> getAllDailyTask(long userId) {
        List<DailyTask> allDailyTask = dailyTaskRepository.findAllByUserId(userId);

        return allDailyTask.stream()
                .map(dailyTask -> mapDailyTaskToDailyTaskResponse(dailyTask))
                .collect(Collectors.toList());
    }

    @Override
    public List<DailyTaskResponse> getAllDailyTaskByDate(long userId, GetTasksByDateRequest request) {
        List<DailyTask> allDailyTask = dailyTaskRepository.findAllByDate(request.getDate());
        List<DailyTask> usersTasks = new ArrayList<>();

        for(DailyTask dt: allDailyTask){
            if(dt.getUser().getId() == userId){
                usersTasks.add(dt);
            }
        }

        return usersTasks.stream()
                .map(dailyTask -> mapDailyTaskToDailyTaskResponse(dailyTask))
                .collect(Collectors.toList());
    }


    private DailyTaskResponse mapDailyTaskToDailyTaskResponse (DailyTask dailyTask) {
        DailyTaskResponse dailyTaskResponse = new DailyTaskResponse();
        dailyTaskResponse.setId(dailyTask.getId());
        dailyTaskResponse.setHours(dailyTask.getHours());
        dailyTaskResponse.setTitle(dailyTask.getTitle());
        dailyTaskResponse.setDate(dailyTask.getDate());

        return dailyTaskResponse;
    }


}
