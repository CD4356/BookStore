package controller;

import entiry.Book;
import service.BookService;
import view.BookAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

/**
 * BookController表示层
 *
 * 对数据库的访问通过业务逻辑层的方法调用来实现
 */
public class BookController extends BookAdmin {

    // 创建BookService实例化对象
    private BookService bookService=new BookService();

    public BookController() {
        queryAll();
    }

    // 将查询的数据转换成二维数组的格式，作为表格中表体的内容
    private String[][] list2Array(ArrayList<Book> list){
        String[][] body=new String[list.size()][4];
        for(int i=0;i<list.size();i++){
            Book book=list.get(i);
            body[i][0]=book.getId();
            body[i][1]=book.getName();
            // valueOf()方法返回非字符串类型数据的字符串表现形式
            body[i][2]= String.valueOf(book.getPrice());
            body[i][3]= String.valueOf(book.getNumber());
        }
        return body;
    }

    @Override
    public void queryAll() {
        String[] head={"图书编号","图书名称","图书价格","图书余量"};
        // 将queryAll()方法返回的数据封装到集合中
        ArrayList<Book> list=bookService.queryAll();
        // 定义一个String类型的二维数组存储list2Array()方法返回的二维数组，这个二位数组就是表格的表体内容
        String[][] body=list2Array(list);
        TableModel tableModel=new DefaultTableModel(body,head);
        table.setModel(tableModel);
    }

    @Override
    public void addBook() {
        String id=addIdText.getText();
        String name=addNameText.getText();
        String price=addPriceText.getText();
        String number=addNumberText.getText();
        boolean addSuccess=bookService.addBook(id,name,Double.parseDouble(price),Integer.parseInt(number));
        if(addSuccess){
            queryAll();
        }else{
            JOptionPane.showMessageDialog(this,"图书已存在！");
        }
    }

    @Override
    public void updateBook() {
        String id=updateIdText.getText();
        String name=updateNameText.getText();
        String price=updatePriceText.getText();
        String number=updateNumberText.getText();
        boolean updateSuccess=bookService.updateBook(id,name,Double.parseDouble(price),Integer.parseInt(number));
        if(updateSuccess){
            queryAll();
        }else{
            JOptionPane.showMessageDialog(this,"图书不存在！");
        }
    }

    @Override
    public void deleteBook() {
        String id=delIdText.getText();
        boolean deleteSuccess=bookService.deleteBook(id);
        if(deleteSuccess){
            queryAll();
        }else{
            JOptionPane.showMessageDialog(this,"图书不存在！");
        }
    }


}
