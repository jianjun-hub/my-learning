package com.jianjun.study.week5;

/**
 * @ClassName TestBookService
 * @Description TODO
 * @Author DARKW
 * @Date 2020/11/2
 **/
public class TestBookService {
    public static void main(String[] args) {
        Book book1 = new Book("1234567891234", "java开发", 12.0);
        Book book2 = new Book("1234567891244", "暴力破解wifi密码", 12.0);
        Book book3 = new Book("123456789125", "js开发", 125.0);
        BookService bs = new BookServiceImpl();
        try {
            boolean b = bs.shelves(book1);
            if(b){
                System.out.println(book1.getBookName()+"成功上架");
            }
        } catch (BookIsbnException | BookNameException | BookPriceException e) {
                System.err.println(e.getMessage());
        }
        try {
            boolean b = bs.shelves(book2);
            System.out.println(book2.getBookName()+"成功上架");
        } catch (BookIsbnException | BookNameException | BookPriceException e) {
            System.err.println(e.getMessage());
        }
        try {
            boolean b = bs.shelves(book3);
            System.out.println(book3.getBookName()+"成功上架");
        } catch (BookIsbnException | BookNameException | BookPriceException e) {
            System.err.println(e.getMessage());
        }
    }
}
