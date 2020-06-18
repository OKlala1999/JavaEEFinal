package com.example.hw.db.service;

import com.example.hw.db.mapper.StudentHomeworkMapper;
import com.example.hw.db.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-517
 */
@Service
public class StudentHomeworkService {

    @Autowired
    private StudentHomeworkMapper studentHomeworkMapper;

    public List<StudentHomework> findAll(){
       return studentHomeworkMapper.findAll();
    }

    public Optional<StudentHomework> findById(int id){
        return studentHomeworkMapper.findById(id);
    }

    public void submitHomework(StudentHomework studentHomework){
        studentHomeworkMapper.save(studentHomework);
    }

    public List<StudentHomework> findByhomeworkId(int id){
        return studentHomeworkMapper.findByHomeworkId(id);
    }

    public List<StudentHomework> findByHidAndSid(int hid,int sid){
        return studentHomeworkMapper.findByHomeworkIdAndStudentId(hid,sid);
    }
}
