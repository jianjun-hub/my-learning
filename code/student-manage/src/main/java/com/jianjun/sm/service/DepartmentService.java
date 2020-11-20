package com.jianjun.sm.service;

import com.jianjun.sm.entity.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 查询所有院系
     *
     * @return List<Department>
     */
    List<Department> selectAll();

    /**
     * 删除院系
     * @param id 院系id
     * @return int
     */
    void delDep(int id);
}
