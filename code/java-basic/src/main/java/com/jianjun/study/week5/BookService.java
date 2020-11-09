package com.jianjun.study.week5;

public interface BookService {
    boolean shelves(Book book) throws BookPriceException, BookIsbnException, BookNameException;
}
