package com.example.demo.dto.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class CreateDailyTaskRequest {

    private String title;
    private int hours;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
}
