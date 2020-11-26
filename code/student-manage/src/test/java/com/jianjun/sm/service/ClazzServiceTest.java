package com.jianjun.sm.service;

import com.jianjun.sm.dao.ClazzDao;
import com.jianjun.sm.entity.Clazz;
import com.jianjun.sm.factory.DaoFactory;
import com.jianjun.sm.factory.ServiceFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClazzServiceTest {


    @Test
    public void selectClazzById() {

       List<Clazz> clazzList = ServiceFactory.getClazzServiceInstance().selectClazzById(1);
       clazzList.forEach(System.out::println);
    }

    @Test
    public void addClazz() {
        int n = 0;
        Clazz clazz = Clazz.builder()
                .departmentId(5)
                .className("软件一班")
                .build();
        n = ServiceFactory.getClazzServiceInstance().addClazz(clazz);
        assertEquals(1,n);
    }

    @Test
    public void delClazz() {
        int n= 0;
        try {
            n = ServiceFactory.getClazzServiceInstance().delClazz(7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(1,n);
    }

    @Test
    public void selectAll() {
        try {
            List<Clazz> clazzList;
            clazzList = ServiceFactory.getClazzServiceInstance().selectAll();
            clazzList.forEach(System.out::println);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}