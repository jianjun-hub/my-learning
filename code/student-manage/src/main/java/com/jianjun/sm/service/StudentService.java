package com.jianjun.sm.service;

import com.jianjun.sm.dao.impl.StudentDaoImpl;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    /**
     * 查询学生列表
     *
     * @return list<StudentVo>
     */
    List<StudentVo> selectAll()  ;


    /**
     * 根据部门id查询学生
     * @param depId 院系id
     * @return list<StudentVo>
     */
    List<StudentVo> selectByDepId(int depId);
    /**
     * 根据班级id查询学生
     * @param classId 班级id
     * @return list<StudentVo>
     */

    List<StudentVo> selectByClassId(int classId);

    /**
     * 根据关键词查询学生
     * @param keywords 关键词
     * @return list<StudentVo>
     */
    List<StudentVo> selectByKeywords(String keywords);
}
