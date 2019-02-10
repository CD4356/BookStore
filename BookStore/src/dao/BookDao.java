package dao;

import entiry.Book;

import java.sql.*;
import java.util.ArrayList;

/**
 * Dao数据访问层
 *
 * 主要是对数据进行增删改查操作的层，也称持久层
 */
public class BookDao {

    /**
     * queryAll()方法
     * 查询所有图书信息，返回一个集合
     * @return
     */
    public ArrayList<Book> queryAll(){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Book> list=new ArrayList<>();
        try{
            conn=DBUtil.getConnection();
            stmt=conn.createStatement();
            String sql="select*from book order by id";
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Book book=new Book();
                // 将获取结果集的信息封装到Book实体类中
                book.setId(rs.getString("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getDouble("price"));
                book.setNumber(rs.getInt("number"));
                // 将实体类中的信息封装到集合中
                list.add(book);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs,stmt,conn);
        }
        return list;
    }

    /**
     * addBook()方法
     * 以实体类Book作为参数类型，实参封装了装备添加到数据库中的图书信息
     *
     * 使用PreparedStatement对象执行插入操作，防止SQL语句注入
     * @return
     */
    public void addBook(Book book){
        Connection conn=null;
        PreparedStatement prestmt=null;
        try{
            conn=DBUtil.getConnection();
            String sql="insert into book(id,name,price,number)values(?,?,?,?)";
            prestmt=conn.prepareStatement(sql);
            prestmt.setString(1,book.getId());
            prestmt.setString(2,book.getName());
            prestmt.setDouble(3,book.getPrice());
            prestmt.setInt(4,book.getNumber());
            int num=prestmt.executeUpdate();
            if(num>0){
                System.out.println("插入数据成功！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(prestmt,conn);
        }
    }

    /**
     * deleteBook方法
     * 删除记录deleteBook()方法中的形参类型为String类型的id,也可改为实体类Book作为形参类型
     *
     * 使用PreparedStatement对象执行删除操作，防止SQL语句注入
     * @return
     */
    public void deleteBook(String id){
        Connection conn=null;
        PreparedStatement prestmt=null;
        try{
            conn=DBUtil.getConnection();
            String sql="delete from book where id=?";
            prestmt=conn.prepareStatement(sql);
            prestmt.setString(1,id);
            int num=prestmt.executeUpdate();
            if(num>0){
                System.out.println("删除数据成功！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(prestmt,conn);
        }
    }

}
