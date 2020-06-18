package com.example.hw.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
@Entity
@Table(name = "s_student_homework")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentHomework {
    @Id
    private int id;

    private int studentId;

    private int homeworkId;

    private String homeworkTitle;

    private String homeworkContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date submitTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private Date updateTime;

    private String comment;

}
