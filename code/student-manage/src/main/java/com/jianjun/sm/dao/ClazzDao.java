package com.jianjun.sm.dao;
import com.jianjun.sm.entity.Clazz;

import java.sql.*;
import java.util.List;

public interface ClazzDao {
    /**
     * 按照院系id查询班级
     *
     * @param departmentId 院系id
     * @return list<Clazz> 院系班级集合
     * @throws SQLException sql异常
     */
    List<Clazz> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 新增班级
     * @param clazz 新增班级实体
     * @return int
     * @throws SQLException sql异常
     */

     int insertClazz(Clazz clazz) throws SQLException;

    /**
     * 删除班级
     * @param id 班级id
     * @return int
     * @throws SQLException sql异常
     */
    int delClazz(int id) throws SQLException;
}
