package com.example.service;

import com.example.beans.Movied;


import java.util.ArrayList;
import java.util.List;

public abstract class SearchMovie implements MovieInterface {

    @Override
    public void add() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }


    public List<Movied> search(){
        //第一一些与前台相关的内容
        List<Movied> mymovied=new ArrayList<>();

        Movied movie1=new Movied("app.media.Sciencefiction11","电影名1","描述1");
        Movied movie2=new Movied("app.media.Sciencefiction12","电影名2","描述2");

        mymovied.add(movie1);
        mymovied.add(movie2);
        return mymovied;


    }


}
