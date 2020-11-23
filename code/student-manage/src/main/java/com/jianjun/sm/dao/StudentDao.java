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
}
