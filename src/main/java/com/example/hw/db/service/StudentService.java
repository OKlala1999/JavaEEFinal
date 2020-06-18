package com.example.hw.db.service;

import com.example.hw.db.mapper.StudentMapper;
import com.example.hw.db.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;

    public Optional<Student> findById(int id){
        return studentMapper.findById(id);
    }

    public void addStudent(Student student){
        studentMapper.save(student);
    }

    public List<Student> findAll(){
        return studentMapper.findAll();
    }
}
