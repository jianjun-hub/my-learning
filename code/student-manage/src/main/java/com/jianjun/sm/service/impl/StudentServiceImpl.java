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
}
