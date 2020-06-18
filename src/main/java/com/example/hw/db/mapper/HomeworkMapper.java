package com.example.hw.db.mapper;

import com.example.hw.db.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
public interface HomeworkMapper extends JpaRepository<Homework,Integer> {

    public Homework findById(int id);
}

