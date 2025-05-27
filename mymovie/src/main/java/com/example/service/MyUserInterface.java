package com.example.service;

import com.example.beans.MyUser;

import java.util.List;
//用来实现用于数据的增删改查的接口的实现。
public interface MyUserInterface {
    //定义一个接口查询所有用过户
    public List<MyUser> findalluser();
    //定义一个增加的接口
    public boolean addUser(MyUser myuser);
    //增加两个接口
    //增加一个删除的方法,删除的时候只可以按照id来删除
    public boolean delUser(int id);
    //再增加一个修改的方法
    public  boolean modiUser(MyUser myUser);

    public MyUser findUserById(int id);

    public MyUser findUserNameById(String myusername);

    public  boolean changepassword(MyUser myUser);
}
