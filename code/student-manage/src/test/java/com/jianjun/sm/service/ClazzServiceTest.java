package com.jianjun.sm.service;

import com.jianjun.sm.dao.ClazzDao;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.factory.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzServiceTest {


    @Test
    public void selectClazzById() {

       List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(1);
       clazzList.forEach(System.out::println);
    }
}