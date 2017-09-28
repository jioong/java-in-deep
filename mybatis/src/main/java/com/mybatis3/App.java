package com.mybatis3;

import com.mybatis3.domain.Student;
import com.mybatis3.mapper.StudentMapper;
import com.mybatis3.util.MyBatisSqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Created by jioong on 17-9-28.
 */
public class App {

    public static void main(String[] args) {
        SqlSessionFactory factory = MyBatisSqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        session.commit(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        Student newStudent = new Student();
        newStudent.setEmail("null");
        newStudent.setId(3);
        newStudent.setName("happy");
        mapper.insertStudent(newStudent);

        Student student = mapper.selectStudentById(2);
        session.commit();
        System.out.println(student);
    }
}
