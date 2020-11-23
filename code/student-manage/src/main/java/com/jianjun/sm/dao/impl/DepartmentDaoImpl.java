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
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public List<Department> getAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String Sql = "SELECT * FROM t_department";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        ResultSet rs = pstmt.executeQuery();
        List<Department> departmentList = new ArrayList<>();
        while (rs.next()) {
            Department department = new Department();
            department.setId(rs.getInt("id"));
            department.setDepartmentName(rs.getString("department_name"));
            department.setLogo(rs.getString("logo"));
            departmentList.add(department);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return departmentList;
    }

    @Override
    public int delDep(int id) throws SQLException {
        int n = 0;
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String Sql = "DELETE FROM t_department WHERE id = ?";
        PreparedStatement pstmt = connection.prepareStatement(Sql);
        pstmt.setInt(1, id);
        n = pstmt.executeUpdate();
        pstmt.close();
        jdbcUtil.closeConnection();
        return n;
    }

    @Override
    public int insertDepartment(Department department) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "insert into t_department(department_name,logo) values(?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,department.getDepartmentName());
        pstmt.setString(2,department.getLogo());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return  n;
    }


}
