package com.mybatis3.mapper;

import com.mybatis3.domain.Student;

/**
 * Created by jioong on 17-9-28.
 */
public interface StudentMapper {
    Student selectStudentById(int id);

    void insertStudent(Student student);
}
