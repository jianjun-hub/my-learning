package com.jianjun.sm.dao;

import com.jianjun.sm.entity.Admin;
import com.jianjun.sm.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AdminDaoTest {
    private final AdminDao adminDao = DaoFactory.getAdminDaoInstance();

    @Test
    public void finAdminByAccount() {
        Admin admin;
        try {
            admin = adminDao.finAdminByAccount("jianjun@qq.com");
            assertEquals("陈健君",admin.getAdminName());
            System.out.println(admin);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}