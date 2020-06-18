package com.example.hw.db.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author fuyongle
 * @version 1.0
 * @date 2020-06-17
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_homework")
public class Homework {

    @Id
    private int id;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private String createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:SS")
    private String deadline;

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime='" + createTime + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
