package com.jianjun.sm.service.impl;

import com.jianjun.sm.dao.DepartmentDao;
import com.jianjun.sm.entity.Department;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName DepartmentServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/17
 **/
public class DepartmentServiceImpl   implements DepartmentService {
    private final DepartmentDao departmentDao = DaoFactory.getDepartmentDaoInstance();
    @Override
    public List<Department> selectAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDao.getAll();
        } catch (SQLException e) {
            System.out.println("查询院系信息出现异常");
        }
        return departmentList;
    }

    @Override
    public int delDep(int id) {
        int n = 0;
        try {
            n = departmentDao.delDep(id);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return n;
    }

    @Override
    public int addDepartment(Department department) {
       int n = 0;
       try {
           n = departmentDao.insertDepartment(department);

       } catch (SQLException e) {
           System.err.print("新增院系出现异常");
       }
       return n;
    }
}
