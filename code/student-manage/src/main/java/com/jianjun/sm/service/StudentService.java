package com.jianjun.sm.service;

import com.jianjun.sm.dao.impl.StudentDaoImpl;
import com.jianjun.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    /**
     * 查询学生列表
     *
     * @return list<StudentVo>
     */
    List<StudentVo> selectAll() ;
}
