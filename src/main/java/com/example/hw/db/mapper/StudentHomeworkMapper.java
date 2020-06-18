package com.example.hw.db.mapper;

import com.example.hw.db.model.Homework;
import com.example.hw.db.model.StudentHomework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
public interface StudentHomeworkMapper extends JpaRepository<StudentHomework,Integer> {

    public List<StudentHomework> findByHomeworkId(int id);

    public List<StudentHomework> findByHomeworkIdAndStudentId(int hid,int sid);

}
