package com.jianjun.sm.dao;

import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzDaoTest {
    private final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();

    @Test
    public void selectByDepartmentId() {
        List<Clazz> clazzList = null;
        try {
            clazzList = clazzDao.selectByDepartmentId(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(clazzList);
    }

    @Test
    public void insertClazz() {
        int n = 0;
        Clazz clazz = Clazz.builder()
                .departmentId(4)
                .className("交通二班")
                .build();
        try {
          n = clazzDao.insertClazz(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1,n);
    }

    @Test
    public void delClazz() {
        int n = 0;
        try {
            n = clazzDao.delClazz(10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertEquals(1,n);
    }
}