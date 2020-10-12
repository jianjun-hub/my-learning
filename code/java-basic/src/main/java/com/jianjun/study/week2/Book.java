package com.jianjun.study.week2;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Book
 * @Description TODO
 * @Author DARKW
 * @Date 2020/10/12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private  String name;
    private  Integer price;
    private Date publishDate;

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = this.publishDate;
        String dateStr = sdf.format(date);
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", publishDate=" + dateStr+
                '}';
    }
}
