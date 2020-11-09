package com.jianjun.study.week5;

import java.util.regex.Pattern;

/**
 * @ClassName BookServiceImpl
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/2
 **/
public class BookServiceImpl implements BookService {

    @Override
    public boolean shelves(Book book) throws BookPriceException, BookIsbnException, BookNameException {
        Pattern pattern = Pattern.compile("[0-9]*");
        String isbn = book.getIsbn();
        double price = book.getPrice();
        String name = book.getBookName();

        if (price > 100) {
            throw new BookPriceException(name+"价格超过100！！");
        } else if (name.contains("暴力") || name.contains("恐怖")) {
            throw new BookNameException(name+"书名含有非法字符!!");
        } else if (isbn.length() != 13 || !pattern.matcher(isbn).matches()) {
            throw new BookIsbnException(name+"isbn不是13位数字！!");
        } else {
            return true;
        }
    }
}
