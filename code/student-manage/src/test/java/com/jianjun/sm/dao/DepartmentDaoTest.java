package com.jianjun.sm.dao;

import com.jianjun.sm.entity.Department;
import com.jianjun.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class DepartmentDaoTest {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();

    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert  departmentList != null;
        departmentList.forEach(System.out::println);
    }

    @Test
    public void insertDepartment() {
        int n = 0;
        Department department = Department.builder()
                .departmentName("测试院系")
                .logo("1.jpg")
                .build();
        try {
            n  = departmentDao.insertDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       assertEquals(1,n);
    }
}