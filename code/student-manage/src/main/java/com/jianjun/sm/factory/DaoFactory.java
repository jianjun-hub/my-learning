package com.jianjun.sm.factory;

import com.jianjun.sm.dao.AdminDao;
import com.jianjun.sm.dao.DepartmentDao;
import com.jianjun.sm.dao.impl.AdminDaoImpl;
import com.jianjun.sm.dao.impl.DepartmentDaoImpl;
import com.jianjun.sm.entity.Department;

/**
 * @ClassName DaoFactory
 * @Description 工厂类
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class DaoFactory {
    /**
     * 获得AdminDao实例
     *
     * @return AdminDao实例
     */
    public static AdminDao getAdminDaoInstance(){
        return new AdminDaoImpl();
    }

    /**
     * 获得DepartmentDao实例
     *
     * @return DepartmentDao实例
     */
    public static DepartmentDao getDepartmentDaoInstance(){
        return new DepartmentDaoImpl();
    }
}
