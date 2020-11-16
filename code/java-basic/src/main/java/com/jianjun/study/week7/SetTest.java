package com.jianjun.study.week7;

 import java.util.Iterator;
 import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName SetTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class SetTest {
    public static void main(String[] args) {
        Set<String> set  = new TreeSet<>();
        set.add("C");
        set.add("B");
        set.add("A");
        System.out.println(set);
        //使用for循环遍历
        System.out.println("使用for循环遍历set");
        for(String s:set){
            System.out.println(s+",");
        }
        //使用iterator遍历
        System.out.println("使用iterator遍历set");
        Iterator<String> iterator =  set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //使用lambda遍历
        System.out.println("使用lambda遍历set");
        set.forEach(s-> System.out.println(s+","));
        System.out.println("使用方法引用遍历set");
        set.forEach(System.out::println);
        Student stu1 = new Student("tom",15);
        Student stu2 = new Student("jon",20);
        Student stu3 = new Student("alex",25);
        Set<Student> sSet = new TreeSet<>();
        sSet.add(stu1);
        sSet.add(stu2);
        sSet.add(stu3);
        System.out.println(sSet);
    }



}
