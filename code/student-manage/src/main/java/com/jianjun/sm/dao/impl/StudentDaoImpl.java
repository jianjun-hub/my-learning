package com.jianjun.sm.dao.impl;

import com.google.gson.internal.bind.SqlDateTypeAdapter;
import com.jianjun.sm.dao.StudentDao;
import com.jianjun.sm.utils.JdbcUtil;
import com.jianjun.sm.vo.StudentVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/23
 **/
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<StudentVo> selectAll() throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select  t1.*,t2.class_name,t3.department_name\n" +
                "from t_student t1\n" +
                "left join t_class t2 on t1.class_id = t2.id\n" +
                "left join t_department t3 on t2.department_id = t3.id";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByDepId(int depId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select t1.*,t2.class_name,t3.department_name from t_student t1\n" +
                "left join t_class t2 on t1.class_id = t2.id\n" +
                "left join t_department t3 on t2.department_id = t3.id\n" +
                "where t3.id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,depId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByClassId(int classId) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select t1.*,t2.class_name,t3.department_name from t_student t1\n" +
                "left join t_class t2 on t1.class_id = t2.id\n" +
                "left join t_department t3 on t2.department_id = t3.id\n" +
                "where t1.class_id = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,classId);
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    @Override
    public List<StudentVo> selectByKeywords(String keywords) throws SQLException {
        JdbcUtil jdbcUtil = JdbcUtil.getInitJdbcUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select t1.*,t2.class_name,t3.department_name from t_student t1\n" +
                "left join t_class t2 on t1.class_id = t2.id\n" +
                "left join t_department t3 on t2.department_id = t3.id\n" +
                "where t1.student_name like ? or t1.address like ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,"%"+keywords+"%");
        pstmt.setString(2,"%"+keywords+"%");
        ResultSet rs = pstmt.executeQuery();
        List<StudentVo> list = convert(rs);
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return list;
    }

    private List<StudentVo> convert(ResultSet rs) throws SQLException{
        List<StudentVo> list = new ArrayList<>();
        while (rs.next()){
            StudentVo student = StudentVo.builder()
                    .id(rs.getString("id"))
                    .departmentName(rs.getString("department_name"))
                    .className(rs.getString("class_name"))
                    .studentName(rs.getString("student_name"))
                    .phone(rs.getString("phone"))
                    .gender(rs.getShort("gender"))
                    .avatar(rs.getString("avatar"))
                    .birthday(rs.getDate("birthday"))
                    .address(rs.getString("address"))
                    .build();
            list.add(student);
        }
        return list;
    }
}
