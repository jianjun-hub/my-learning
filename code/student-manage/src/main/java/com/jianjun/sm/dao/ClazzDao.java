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
}
