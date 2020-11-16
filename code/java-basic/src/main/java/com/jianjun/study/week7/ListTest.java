package com.jianjun.study.week7;

import com.sun.xml.internal.bind.v2.runtime.output.DOMOutput;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName ListTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class ListTest {
    public static void main(String[] args) {
        //创建一个list接口的实现类对象，泛型为String
        ArrayList<String> list = new ArrayList<>();
        //增加三个元素
        list.add("Java");
        list.add("JavaScript");
        list.add("Java");
        //随机取出list中某个元素;
        System.out.println("随机取出list中的某个元素");
        int index = (int) (Math.random()*3);
        System.out.println(list.get(index));
        //用for循环遍历List
        System.out.println("用for循环遍历List");
        for(String s:list){
            System.out.println(s+",");
        }
        //用Iterator迭代器遍历list
        System.out.println("用Iterator迭代器遍历list");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next()+",");
        }
        //用lambda表达式遍历list
        System.out.println("用lambda表达式遍历list");
        list.forEach(s-> System.out.println(s));
        System.out.println("使用方法引用遍历list,终极简单版本");
        list.forEach(System.out::println);

    }
}
