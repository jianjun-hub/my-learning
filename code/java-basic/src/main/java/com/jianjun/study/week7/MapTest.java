package com.jianjun.study.week7;

import lombok.Value;
import lombok.val;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName MapTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/16
 **/
public class MapTest {
    public static void main(String[] args) {
//        Map<String,String> map = new HashMap<>();
//        map.put("中国","北京");
//        map.put("美国","华盛顿");
//        map.put("日本","东京");
//        //for循环遍历
//        for (String key:map.keySet()){
//            String value = map.get(key);
//            System.out.println(key + "的首都是" + value);
//        }
//        //iterator遍历
//        System.out.println("iterator遍历");
//        Iterator<Map.Entry<String,String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String,String> entry = iterator.next();
//            System.out.println(entry.getKey() + "的首都是" + entry.getValue());
//        }
//        //通过遍历map的values,只能遍历b=value,获取不到key
//        System.out.println("通过遍历map的values,只能遍历b=value,获取不到key");
//        for (String value:map.values()){
//            System.out.println(value);
//        }
//        //遍历map的entrySet,遍历key 和 value
//        System.out.println("遍历map的entrySet,遍历key 和 value");
//        for(Map.Entry<String,String> entry:map.entrySet()){
//            System.out.println(entry.getKey() + "的首都是" + entry.getValue());
//        }
//        //lambda表达式
//        System.out.println("lambda表达式遍历");
//        map.forEach((key,value)->System.out.println("key:"+key+",value"+value));


        Map<String,String> map1 = new HashMap<>() ;
        map1.put("Tom","CoreJava");
        map1.put("John","Oracle");
        map1.put("Susan","Oracle");
        map1.put("Jerry","JDBC");
        map1.put("Jim","Unix");
        map1.put("Kevin","JSP");
        map1.put("Lucy","JSP");
        map1.put("Allen","JDBC");
        map1.replace("Lucy","CoreJava");
        System.out.println("for循环遍历");
        for(String key: map1.keySet()){
            String value = map1.get(key);
            System.out.println("老师: "+key+" 课程："+value);
        }
        System.out.println("lambda表达式");
        map1.forEach((key,value)-> System.out.println("老师："+key+" 课程："+value));
        System.out.println("所有教jdbc的老师");
        for(String key: map1.keySet()){
            String value = map1.get(key);
            if(value.equals("JDBC")){
                System.out.println(key);
            }
        }
    }
}
