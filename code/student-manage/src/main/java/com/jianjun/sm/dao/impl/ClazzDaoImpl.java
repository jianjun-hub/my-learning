package com.jianjun.sm.dao.impl;

import com.jianjun.sm.dao.ClazzDao;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.utils.JdbcUtil;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ClazzDaoImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/21
 **/
public class ClazzDaoImpl implements ClazzDao {
    @Override
    public List<Clazz> selectByDepartmentId(int departmentId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select * from t_class where department_id = ? order by id desc";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, departmentId);
        ResultSet rs = pstmt.executeQuery();
        List<Clazz> clazzList = new ArrayList<>();
        while (rs.next()) {
            Clazz clazz = new Clazz();
            clazz.setId(rs.getInt("id"));
            clazz.setDepartmentId(rs.getInt("department_id"));
            clazz.setClassName(rs.getString("class_Name"));
            clazzList.add(clazz);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return clazzList;
    }
}
