package com.example.utils;

import com.example.beans.MyFilm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyCollectManager {
    //收藏的增删改查，一个人在整个app的操作只有一个收藏可以操作
    //单例：在整个app的生命周期里只有一次实例化的可能性就是单例
    //首先满足封装私有化,构建一个个收藏，这个车里有所用用户感兴趣的产品
    //所有用户都用一个收藏，这个收藏app生命周期中一致，就是单例，单例中存在每一个用户对应该存在的商品，
    //用户对应的键名是String类型，后面弥漫对应的用户的收藏List，List中有很多商品
    private static ArrayList<Map<String, List<MyFilm>>> mycollect=null;
    //写一个单例的实例化方法
    public static ArrayList<Map<String, List<MyFilm>>> getInstance() {
       if (mycollect!=null){
              return  mycollect;
       }
       //如果mycart不为空，只实例化一次即可
       mycollect=new ArrayList<>();
       return  mycollect;
    }


    /*
     * 添加
     *
     * */
    //实现单例的增删改查，，这里只可能传入一个商品，添加商品的时候还要传入一个用户
    //myUser是具体的用户2，myFilm是具体的用户
    public static List<MyFilm> addcollect(MyFilm myfilm, String myUser){
        System.out.println(myfilm);
        System.out.println(myUser);
        System.out.println(MyCollectManager.getInstance());
        //查询给定用户的收藏中是否有商品,循环所有的收藏查询是否有商品,只要添加标志位，默认为没有
//        List<Map<String,List<MyFilm>>>
        for(Map<String,List<MyFilm>> myitem:MyCollectManager.getInstance()){
            System.out.println(myitem);
            //这里当前用户收藏中的内容，如果内容为空表示用户已经在收藏中添加过内容
            //这里get是hashmap的用法
            if (myitem.get(myUser)!=null){
                //这里是add是List中的用法
                myitem.get(myUser).add(myfilm);

                return myitem.get(myUser);
            }
        }
        //都比较完后再看mycollect中是否myUser的键

           //如果flag一直没有变成ture，证明收藏中没有该用户的车
           List<MyFilm> myLists=new ArrayList<>();
           //把当前用户刚给空集合
           myLists.add(myfilm);
           //把收藏2给hashmap用户
            Map<String,List<MyFilm>> mymap=new HashMap<>();
            //put就是放在mycollect中
            mymap.put(myUser,myLists);
            //再放在初始化的收藏mycart中
             MyCollectManager.getInstance().add(mymap);
        System.out.println(MyCollectManager.getInstance());
            return  myLists;
    }
    /*
     * 删除
     *
     * */
    //删除收藏的操作方法
    public static  List<MyFilm> deleteMycollect (String usernamme,int delIndex){
        //遍历收藏内的商品查找用户,因为有前端配合，基本上收藏内删除的商品一定存在
        for (Map<String,List<MyFilm>> myitem:MyCollectManager.getInstance()){
            if (myitem.get(usernamme)!=null){
                //删除收藏内的电影
                myitem.get(usernamme).remove(delIndex);
                //由于一个用户一个收藏，发现用户的收藏馆，把电影删除，就可以退出循环
                return  myitem.get(usernamme);
            }
        }
        return null;
    }
     /*
     * 更新
     *
     * */
    //更新收藏方法，这里也需要两个参数，一个是电影，一个是用户名
    public static List<MyFilm> updateMycollect(MyFilm myFilm,String username){
        //遍历整个购物车,找到用户的具体电影
        for (Map<String,List<MyFilm>>myitem:MyCollectManager.getInstance()){
            if (myitem.get(username) == null) {
                //相当于收藏与myFilm中的电脑应不合格换成合格的
                //无论怎么修改，都需要遍历，遍历寻找电影，先删除后再添加一个新的myFilm
                //先定义一个变量取该用户的购物车
                List<MyFilm> myFilms=myitem.get(username);
                for (int i=0;i<myFilms.size();i++){
                    //一个月循环myFilms中的元素，使用get方法获取
                     //因为mythFilm和myFilm一定不相等，这里两个电影修改，只有id相等
                    MyFilm mythFilm=myFilms.get(i);
                    //整合力遍历每一个元素都需要和myFilm对比
                     //这里myotherscene与myscene一定是不相等的，这里两个电影修改，只有id相等
                    if (mythFilm.getId()==myFilm.getId()){
                        //移除只能用index，这里不可以使用增强for
                         //查到相同的电影后，直接去掉前面的电影就可以了
                        myFilms.remove(i);
                        //去掉后相当于循环只找到电影的目的，没有必要继续循环，直接退出
                        break;

                    }
                }
                //循环结束后，直接把商品放在用户的键中
                myitem.get(username).add(myFilm);
                return myitem.get(username);
            }
        }
       return null;
    }
    /*
     * 查询
     *
     * */
    //查询收藏方法，只需知道是哪一个用户就可以，只返回一个购物车,返回当前用户购物车
      public  static List<MyFilm> findMycollect(String username){
        //遍历所有购物车，只返回该用户
          for (Map<String,List<MyFilm>>myitem:MyCollectManager.getInstance()) {
              if (myitem.get(username)!=null){
                  return myitem.get(username);
              }
          }
          //这里返回为空不需要调用mycollect
          return  new ArrayList<>();
      }


}
