package com.example.demo.repository;

import com.example.demo.entity.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface IDailyTaskRepository extends JpaRepository <DailyTask , Long> {

    List<DailyTask> findAllByUser_Id (Long id);

    DailyTask findOneByTitle (String title);

    List<DailyTask> findAllByDate (Date date);

    List<DailyTask> findAllByDateAndUserId(Date date, long id);

    List<DailyTask> findAllByUserId(long id);

}
