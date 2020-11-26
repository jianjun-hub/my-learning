package com.jianjun.sm.service.impl;

import com.jianjun.sm.dao.StudentDao;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.service.StudentService;
import com.jianjun.sm.vo.StudentVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/23
 **/
public class StudentServiceImpl  implements StudentService {
    private final StudentDao studentDao = DaoFactory.getStudentDaoInstance();
    @Override
    public List<StudentVo> selectAll() {
      List<StudentVo> studentVoList = null;
      try {
          studentVoList = studentDao.selectAll();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return studentVoList;
    }

    @Override
    public List<StudentVo> selectByDepId(int depId) {
        List<StudentVo> studentVoList = null;
        try {
            studentVoList = studentDao.selectByDepId(depId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVoList;
    }

    @Override
    public List<StudentVo> selectByClassId(int classId) {
        List<StudentVo> studentVoList = null;
        try {
            studentVoList = studentDao.selectByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVoList;
    }

    @Override
    public List<StudentVo> selectByKeywords(String keywords) {
        List<StudentVo> studentVoList = null;
        try {
            studentVoList = studentDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentVoList;
    }
}
