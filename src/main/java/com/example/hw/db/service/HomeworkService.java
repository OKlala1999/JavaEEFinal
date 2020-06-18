package com.example.hw.db.service;

import com.example.hw.db.mapper.HomeworkMapper;
import com.example.hw.db.model.Homework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HomeworkService {
    @Autowired
    HomeworkMapper homeworkMapper;
    public List<Homework> findAll(){
        return homeworkMapper.findAll();
    }

    public void addHomework(Homework homework){
        homeworkMapper.save(homework);
    }

    public Homework findByHomeworkId(int id){
        return homeworkMapper.findById(id);
    }
}
