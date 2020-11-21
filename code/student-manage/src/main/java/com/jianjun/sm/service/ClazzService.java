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
}
