package com.example.demo.repository;

import com.example.demo.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IDailyTaskRepository extends JpaRepository <DailyTask , UUID> {

    List<DailyTask> findAllByUser_Id (UUID id);

}
