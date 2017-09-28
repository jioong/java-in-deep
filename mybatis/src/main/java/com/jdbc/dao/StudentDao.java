package com.jdbc.dao;

import com.mybatis3.domain.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jioong on 17-9-28.
 */
public class StudentDao {

    public static void main(String[] args) {
        new StudentDao().insertStudent();
    }


    public void insertStudent() {
        Connection conn = Util.getConnection();
        String sql = "insert into student(id, name, email) values(1, 'happy', 'liujiong@163.com')";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
