package com.example.hw.db.service;

import com.example.hw.db.mapper.TeacherMapper;
import com.example.hw.db.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-517
 */
@Service
public class TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    public Optional<Teacher> findById(int id){
        return teacherMapper.findById(id);
    }

    public void addTeacher(Teacher teacher){
        teacherMapper.save(teacher);
    }
}
