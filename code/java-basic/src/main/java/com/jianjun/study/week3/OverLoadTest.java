package com.jianjun.study.week3;

import javax.xml.transform.Result;

/**
 * @ClassName OverLoadTest
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/19
 **/
public class OverLoadTest {
    public int sum(int a, int b) {
        return a + b;
    }

    public String sum(String s1, String s2) {
        return s1 + s2;
    }

    public String sumS(int a, int b) {
        int sum = a + b;
        String result = "";

        if (sum < 0) {
            result = "非法参数";
        } else {
            result = sum / 604800 + "星期"
                    + (sum % 604800) / 86400 + "天"
                    + ((sum % 604800) % 86400) / 3600 + "小时"
                    + (((sum % 604800) % 86400) % 3600) / 60 + "分钟"
                    + (((sum % 604800) % 86400) % 3600) % 60 + "秒";
        }
        return result;
    }
}
