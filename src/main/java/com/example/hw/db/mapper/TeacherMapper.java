package com.example.hw.db.mapper;

import com.example.hw.db.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
public interface TeacherMapper extends JpaRepository<Teacher,Integer> {
}
