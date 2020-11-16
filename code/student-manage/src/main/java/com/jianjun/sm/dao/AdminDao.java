package com.jianjun.sm.dao;

import com.jianjun.sm.entity.Admin;

import java.sql.SQLException;

public interface AdminDao {
    /**
     * 根据账号查找管理员
     *
     * @param account:账号入参
     * @return Admin:管理员信息
     * @throws SQLException 该方法会抛出sql异常
     *
     */
    Admin finAdminByAccount(String account) throws SQLException;

}
