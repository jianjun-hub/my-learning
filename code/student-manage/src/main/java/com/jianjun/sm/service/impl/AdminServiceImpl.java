package com.jianjun.sm.service.impl;

import com.jianjun.sm.dao.AdminDao;
import com.jianjun.sm.entity.Admin;
import com.jianjun.sm.entity.ResultEntity;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;

import java.lang.annotation.ElementType;
import java.sql.SQLException;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao = DaoFactory.getAdminDaoInstance();

    public ResultEntity adminLogin(String account, String password) {
        ResultEntity resultEntity;
        Admin admin = null;
        try {
            //根据账号查找管理员信息，捕获异常
            admin = adminDao.finAdminByAccount(account);
        } catch (SQLException e) {
            System.err.println("根据账号查找管理员信息出现异常");
        }
        //根据账号查找到了记录
        if(admin != null){
            //比较密码，此时需要将客户端传过来的密码进行MD5加密后才能比对
            if(DigestUtils.md5Hex(password).equals(admin.getPassword())) {

                resultEntity = ResultEntity.builder().code(0).message("登录成功").data(admin).build();

            }else {
                //账号存在，密码输入错误
                resultEntity = ResultEntity.builder().code(1).message("密码错误").data(admin).build();
            }

        }else {
            //账号不存在
            resultEntity = ResultEntity.builder().code(2).message("账号不存在").build();
        }
        return resultEntity;
    }


}
