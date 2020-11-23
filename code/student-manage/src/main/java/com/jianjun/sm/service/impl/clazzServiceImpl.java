package com.jianjun.sm.service.impl;

import com.jianjun.sm.dao.ClazzDao;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.entity.ResultEntity;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.service.ClazzService;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName clazzServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/21
 **/
public class clazzServiceImpl implements ClazzService {
    private  final ClazzDao clazzDao = DaoFactory.getClazzDaoInstance();
    @Override
    public List<Clazz> selectClazzById(int departmentId) {
        List<Clazz> clazzList = null;
        try {
            clazzList = clazzDao.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            System.err.print("查询班级出现异常！");
        }
        return clazzList;
    }

    @Override
    public int addClazz(Clazz clazz) {
        int n = 0;
        try {
            n = DaoFactory.getClazzDaoInstance().insertClazz(clazz);
        } catch (Exception e) {
            System.err.print("插入班级出现异常");
        }
        return n;
    }

    @Override
    public int delClazz(int id) {
        int n = 0;
        try {
            n = DaoFactory.getClazzDaoInstance().delClazz(id);
        } catch (SQLException e) {
            System.err.print("插入班级出现异常");
        }
        return n;
    }

}
