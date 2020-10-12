package com.jianjun.study.week2;

import java.util.Date;

/**
 * @ClassName GroupTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/12
 **/
public class GroupTest {
    public static void main(String[] args) {
        Book book1 = new Book("java入门",50,new Date());
        Book book2 = new Book("java高级技巧",50,new Date());
        Book book3 = new Book("java项目实践",50,new Date());
        Book book4 = new Book("java基础",50,new Date());


        Phone phone1 = new Phone("华为p30",5000);
        Phone phone2 = new Phone("华为p40",8000);
        Phone phone3 = new Phone("华为mate30",6000);


        Student student1 = new Student("20001","张三","男",phone1,new Book[]{book1,book3});
        Student student2 = new Student("20003","里斯","女",phone2,new Book[]{book4});
        Student student3 = new Student("20005","王大","男",phone3,new Book[]{book1,book2,book3});

        Group group1 = new Group("The king of java",new Student[]{student1,student2,student3});

        for (Student student : group1.getStudents()) {
            System.out.println(student.getName());
        }
    }
}
