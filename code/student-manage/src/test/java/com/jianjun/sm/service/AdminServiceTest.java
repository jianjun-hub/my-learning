package com.jianjun.sm.service;

import com.jianjun.sm.entity.ResultEntity;
import com.jianjun.sm.factory.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminServiceTest {

    private  final  AdminService adminService = ServiceFactory.getAdminServiceInstance();

    @Test
    public void adminLogin() {
        ResultEntity resultEntity = adminService.adminLogin("jianjun@qq.com","123568");
        assertEquals(0,resultEntity.getCode());
        System.out.println(resultEntity);
    }
}