package com.example.service;

import com.example.beans.Movied;
import com.example.beans.MyFilm;
import com.example.beans.MyMovieCategory;

import java.util.List;

/*
先建立一个查询电影的接口，接口的关键字是interface

 */
public interface MyMovieInterface {
    //查询电影
    public List<MyMovieCategory> findAllMovie();

    public List<MyFilm> findMovie();
    //增加电影
    public boolean addMovie(MyFilm myFilm);
    //删除电影
    public boolean delMovie(int id);
    //修改电影
    public boolean modiMovie(MyFilm myFilm);
    //查询单一id的电影信息
    public MyFilm findMovieById(int id);

    //单查一个名
    public List<MyFilm> findonemovies(String myFilm);

    //首页的下方
    public List<MyFilm> findallMovieIndex();
}
