package com.jianjun.sm.factory;

import com.jianjun.sm.entity.Admin;
import com.jianjun.sm.service.AdminService;
import com.jianjun.sm.service.impl.AdminServiceImpl;

/**
 * @ClassName ServiceFactory
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class ServiceFactory {
    public static AdminService getAdminServiceInstance(){
        return  new AdminServiceImpl();
    }
}
