package service;

import dao.BookDao;
import entiry.Book;

import java.util.ArrayList;

/**
 * Service业务逻辑层
 *
 * 主要是调用Dao数据访问层的基本数据操作来完成业务逻辑处理
 */
public class BookService {

    // 创建AdminDao实例化对象
    private BookDao bookDao=new BookDao();

    // 实现查询逻辑处理
    public ArrayList<Book> queryAll(){
        ArrayList data=bookDao.queryAll();
        return data;
    }

    // 实现添加逻辑处理
    public boolean addBook(String id, String name, double price, int number){
        // 遍历数据，判断要插入的水果编号是否存在
        ArrayList<Book> data=queryAll();
        for(int i=0;i<data.size();i++){
            Book book=data.get(i);
            if(id.equals(book.getId())){
                return false;
            }
        }
        Book thisbook=new Book(id,name,price,number);
        bookDao.addBook(thisbook);
        return true;
    }

    /**
     * BookDao中没有定义修改操作的方法，我们这个小项目中不是通过执行修改SQL语句来实现数据修改的，
     * 而是通过删除要修改的数据后，再添加新的数据的方式来实现数据修改的
     * @return
     */
    public boolean updateBook(String id, String name, double price, int number) {
        // 遍历数据，判断要插入的水果编号是否存在
        ArrayList<Book> data=queryAll();
        for(int i=0;i<data.size();i++){
            Book book=data.get(i);
            if(id.equals(book.getId())){
                // 如果该图书存在则删除
                bookDao.deleteBook(id);
                // 添加修改内容作为新的图书内容
                Book thisbook=new Book(id,name,price,number);
                bookDao.addBook(thisbook);
                /**
                 * 这里不要使用BookService类中的deleteBook()和addBook()方法来删除添加图书，
                 * 因为这两个方法都要遍历一次数据，如果数据量很大的话就会消耗很多时间，
                 * 所以应如上面三行代码这样，直接调用BookDao类中的方法来实现图书的删除添加
                 */
//                deleteBook(id);
//                addBook(id,name,price,number);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(String id) {
        // 遍历数据，判断要插入的水果编号是否存在
        ArrayList<Book> data=queryAll();
        for(int i=0;i<data.size();i++){
            Book book=data.get(i);
            if(id.equals(book.getId())){
                bookDao.deleteBook(id);
                return true;
            }
        }
        return false;
    }



}
