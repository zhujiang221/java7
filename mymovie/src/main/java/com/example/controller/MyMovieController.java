package com.example.controller;

import com.example.beans.MyFilm;
import com.example.beans.MyMovieCategory;
import com.example.beans.MyResult;
import com.example.beans.MyUser;
import com.example.service.MyMovieInterface;
import com.example.service.MyMovieInterfaceImpl;
import com.example.utils.MyMovieIndexNewJDBCUtils;
import com.example.utils.MyMovieNewJDBCUtils;
import com.example.utils.MyMovieOneJDBCUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/")
public class MyMovieController {

    //实例化service的类
    private MyMovieInterfaceImpl mymovieimpl = new MyMovieInterfaceImpl();
    @RequestMapping("/addmovie")
    public String addUser(MyFilm myuser){
        if (mymovieimpl.addMovie(myuser)) {
            return  "增加用户成功";
        }else {
            return "增加用户失败";
        }
    }

    //在定义一个删除电影的方法
    @RequestMapping("/delMovie")
    public String delMovie(int id){
        if (mymovieimpl.delMovie(id) ){
            return "删除电影成功";
        }else {
            return "删除电影失败";
        }
    }


    //在定义一个更新用户的方法
    @GetMapping("/updatemovie")
    public String updateMovie(MyFilm myFilm){

        if (mymovieimpl.modiMovie(myFilm)) {
            return "更新电影成功";
        }else {
            return "更新电影失败";
        }
    }



    //产生一个id查询某个电影的方法
    @RequestMapping("/findonemovie")
    public  String findonemovie(int id){
        return mymovieimpl.findMovieById(id).toString();
    }
    //查询所有的电影
    @RequestMapping("/findmovie")
    public String findmovie(){
        return MyMovieNewJDBCUtils.myConnextDatabase().toString();
    }
    //查询单个名字的电影
    @RequestMapping("/findnamemovie")
    public  String findnamemovie(String moviename){
        return mymovieimpl.findonemovies(moviename).toString();
    }
    @RequestMapping("/findindex")
    public String findindex(){
        return MyMovieIndexNewJDBCUtils.myConnextDatabase().toString();
    }
    //给地址
    @RequestMapping("/findallmovie")
    public  List<MyResult> findmymovie(){
        //在这里返回值实例化
        List<MyResult> myreturns=new ArrayList<>();
        //service中得到数据库的查询结果
        List<MyMovieCategory> mylist=mymovieimpl.findAllMovie();
        //对数据便利之前，需要定义记录上次循环的变量，初始化不记录任何ID,上次是prev
        int prev=0;
        //因为在循环中取不到上一次的cataname，这里还要记录上一次的catename
        String prevname="";
        //因为在else中调用不到变量，对这个获取的数据做遍历操作，对Arraylist列表，size（）是获取列表长
        List<MyFilm> myfilms=new ArrayList<>();
        //上面不满足我们的需求，对这个获取的数值遍历,对arraylist列表，size是获取长度
        for (int i = 0; i <mylist.size(); i++) {
            //获取便利类型中的cateid,在arraylist中的某一个引锁使用get方法获取
            MyMovieCategory mymovie=mylist.get(i);
            //获取商品cate蕾蕾id，这个记录本次循环的记录id
            int current=mymovie.getCateid();
            //当前的current的id与上一次的prev的id相同，就在列表中加载数据，否则就产生一个个新的数据
            if (current==prev){
            }else {
                if (prev!=0){
                    //这里分类不同的就产生一个新的结果实例
                    MyResult myresult=new MyResult();
                    //这里建立的商品列表，list中商品没有分类这里有一个电影类
                    myresult.setCateid(prev);
                    //还需要一个catename，这里去不到上一次的cataname
                    myresult.setCatename(prevname);
                    //这里myfilms就是之前记录的所有电影，只有先赋值在清空，才能记录所有商品的值
                    myresult.setMyresults(myfilms);
                    //再把Myresult放在列表中
                    myreturns.add(myresult);
                }
                //这里建立商品列表，list中只有电影名，没有分类，这里有一个电影的类
                myfilms = new ArrayList<>();
            }
            //实例化当前对象，放在商品中,不管if，
            MyFilm myfilm=new MyFilm();
            myfilm.setId(mymovie.getId());
            myfilm.setMoviename(mymovie.getMoviename());
            myfilm.setDescription(mymovie.getDescription());
            myfilm.setPic(mymovie.getPic());
            myfilms.add(myfilm);
            prev=current;
            //不但要记住上一次的值，还要记住上一次的分类
            prevname= mymovie.getCatename();
            // 处理最后一组数据
        }
        //防止最后一条被循环退出
        //这里分类不同的就产生一个新的结果实例
        MyResult myresult=new MyResult();
        //这里建立的商品列表，list中商品没有分类这里有一个电影类
        myresult.setCateid(prev);
        //还需要一个catename，这里去不到上一次的cataname
        myresult.setCatename(prevname);
        //这里myfilms就是之前记录的所有电影，只有先赋值在清空，才能记录所有商品的值
        myresult.setMyresults(myfilms);
        //再把Myresult放在列表中
        myreturns.add(myresult);
        //循环体结束，都把本次循环的id作为下一次循环的记录项
        return myreturns;
    }


}
