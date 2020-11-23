package com.jianjun.sm.service;

import com.jianjun.sm.dao.StudentDao;
import com.jianjun.sm.factory.ServiceFactory;
import com.jianjun.sm.vo.StudentVo;
import com.mysql.cj.x.protobuf.MysqlxCursor;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceTest {
    private final StudentService  studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void selectAll() {
        List<StudentVo> studentVoList = studentService.selectAll();
        studentVoList.forEach(System.out::println);


    }

}