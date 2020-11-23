package com.jianjun.sm.service;

import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.entity.ResultEntity;

import java.util.List;

/**
 * @author DARKW
 */
public interface ClazzService {
    /**
     * 通过院系id查询班级
     *
     * @param departmentId 院系id
     * @return ResultEntity
     */
    List<Clazz> selectClazzById(int departmentId);

    /**
     * 插入新班级
     * @param clazz 新增班级实体
     * @return int;
     */
    int addClazz(Clazz clazz);

    /**
     * 删除班级
     * @param id 班级id
     * @return int
     */
    int delClazz(int id);
}
