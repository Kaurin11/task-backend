package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyTaskResponse {

    private Long id;
    private String title;
    private int hours;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;


}
