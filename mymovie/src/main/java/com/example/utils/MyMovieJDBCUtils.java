package com.example.utils;
import com.example.beans.MyMovieCategory;
import com.example.beans.MyUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public final class MyMovieJDBCUtils {
/*
java连接数据库工具类，因为是工具类，不惜要继承，加入final修饰
 */
//    public static void main(String[] args) {
//        MyUser myUser=new MyUser();
//        myUser.setUsername("admin");
//        myUser.setPassword("123456");
//        myConnextDatabase(myUser);
//
//    }
    //数据库连接方法,工具类的方法需要加入static静态
    public static List<MyMovieCategory> myConnextDatabase(){

        //先定义一个arrylist列表，只进行记录不进行计算
        List<MyMovieCategory> lists=new ArrayList<>();
        try {
            //注册驱动，java连按mysql的驱动注册
            //mysql5.X驱动com.mysql.jdbc.Driver
            //mysql8.X驱列com.mysql.ci.idbc.Driver
            Class.forName("com.mysql.jdbc.Driver");
            //连接各用户名密码，连接用户固定root
            //获取数据库连接,注意连接有参数
            //地址，前面内容一致 jdbc:mysql://localhost:3306/ 后面跟上数据库的名称
            String url="jdbc:mysql://localhost:3306/mymovie?characterEncoding=utf8&useSSL=false";
            String username="root";
            String password="123456";
            //获取数据库连接,得到连接,Connection是iava.sql包的Connection
            Connection conn= DriverManager.getConnection(url,username,password);
            //执行电影查找的sql，查找分类，也查找分类对应的电影，典型的两表查询的差困
            //一种写法 where: SELECT * FROM mycategory,mymovies WHERE mycategory.id = mymovies.cateid;
            String sql="SELECT * FROM mymovies,mycategory WHERE mycategory.id = mymovies.cateid";
            //调用Preparedstatement对象，这是执行sql语句的对象,得到的结果是PreparedStatement对象,
            //这里只把sql语句传入这个对象中

            PreparedStatement ps=conn.prepareStatement(sql);
            //执行sql语句,执行査询executeQuery()查询，得到的结果是ResultSet
//            ps.setString(1, myuser.getUsername());
//            ps.setString(2, myuser.getPassword());
            ResultSet rs=ps.executeQuery();



            //这个结果是一个集合，需要while循环打印，如果ResultSet中next()有效，表示有下一个数据就打印数据
            while (rs.next()){
                //新建一个对象类
                MyMovieCategory mymoviecategory=new MyMovieCategory();

                mymoviecategory.setId(rs.getInt("id"));

                mymoviecategory.setCateid(rs.getInt("cateid"));

                mymoviecategory.setMoviename(rs.getString("moviename"));

                mymoviecategory.setDescription(rs.getString("description"));

                mymoviecategory.setPic(rs.getString("pic"));

                mymoviecategory.setCatename(rs.getString("catename"));

                //在arraylist谁存储列表中使用add
                lists.add(mymoviecategory);
                //不能直接返回，把所有电影额next（）方法查询结束后返回，去掉return 不需要返回，把所有电影处理完成后返回
                //return myuser;
            }
        }catch (Exception e){
        }
        return lists;
    }

}
