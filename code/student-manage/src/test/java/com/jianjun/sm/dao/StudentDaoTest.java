package com.jianjun.sm.dao;

import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.vo.StudentVo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDaoTest {


    @Test
    public void selectAll()throws SQLException {
        try {
            List<StudentVo> list = DaoFactory.getStudentDaoInstance().selectAll();
            list.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}