package com.jianjun.sm.dao.impl;

import com.jianjun.sm.dao.DepartmentDao;
import com.jianjun.sm.entity.Department;
import com.jianjun.sm.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DepartmtentDaoImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/17
 **/
public class DepartmentDaoImpl  implements DepartmentDao {
    @Override
    public List<Department> getAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String Sql = "SELECT * FROM t_department";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while (rs.next()){
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLogo(rs.getString("logo"));
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return  departmentList;
    }
}
