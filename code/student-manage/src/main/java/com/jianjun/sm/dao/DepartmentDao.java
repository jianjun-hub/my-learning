package com.jianjun.sm.dao;
import com.jianjun.sm.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDao {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     * @throws SQLException 异常
     */

    List<Department> getAll() throws SQLException;
    /**
     * 删除院系
     * @param id 院系id
     * @throws SQLException 异常
     */
     void delDep(int id) throws  SQLException;
}
