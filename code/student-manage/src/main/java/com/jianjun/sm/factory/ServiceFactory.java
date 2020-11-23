package com.jianjun.sm.factory;

import com.jianjun.sm.entity.Admin;
import com.jianjun.sm.service.AdminService;
import com.jianjun.sm.service.ClazzService;
import com.jianjun.sm.service.DepartmentService;
import com.jianjun.sm.service.StudentService;
import com.jianjun.sm.service.impl.AdminServiceImpl;
import com.jianjun.sm.service.impl.DepartmentServiceImpl;
import com.jianjun.sm.service.impl.StudentServiceImpl;
import com.jianjun.sm.service.impl.clazzServiceImpl;

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

    public  static DepartmentService getDepartmentServiceInstance(){
        return  new DepartmentServiceImpl();
    }

    public static ClazzService getClazzServiceInstance(){return new clazzServiceImpl();}

    public static StudentService getStudentServiceInstance(){return new StudentServiceImpl();
    }
    }

