package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class DailyTask extends BaseEntity{

    private String title;
    private int hours;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn (name = "user_id" )
    private User user;

}
