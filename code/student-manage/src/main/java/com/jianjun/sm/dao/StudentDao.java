package com.jianjun.sm.dao;
import com.jianjun.sm.vo.StudentVo;

import  java.sql.*;
import java.util.List;

/**
 * @author DARKW
 */
public interface StudentDao {
    /**
     * 查询所有学生
     * @return 学生视图列表数据
     * @throws SQLException sql异常
     */
    List<StudentVo> selectAll() throws SQLException;

    /**
     * 根据院系id查询学生
     * @param depId 院系id
     * @return list
     * @throws SQLException sql异常
     */
    List<StudentVo> selectByDepId(int depId) throws SQLException;

    /**
     * 根据班级id查询学生
     * @param classId 班级id
     * @return list
     * @throws SQLException sql异常
     */
    List<StudentVo> selectByClassId(int classId)throws SQLException;

    /**
     * 根据关键字查询学生
     * @param keywords 关键字
     * @return list
     * @throws SQLException sql异常
     */
    List<StudentVo> selectByKeywords(String keywords) throws  SQLException;
}


