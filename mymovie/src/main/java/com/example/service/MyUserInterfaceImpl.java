package com.example.service;

import com.alibaba.fastjson.JSONObject;
import com.example.beans.MyUser;
import com.example.utils.*;

import java.util.Collections;
import java.util.List;

public class MyUserInterfaceImpl implements  MyUserInterface{

    @Override
    public List<MyUser> findalluser() {
        return MyUserJDBCUtils.myConnextDatabase();
    }

    @Override
    public boolean addUser(MyUser myuser) {
        return MyUserInsertUtils.myConnextDatabase(myuser);
    }

    @Override
    public boolean delUser(int id){return MyUserDeleteUtils.myConnextDatabase(id);}

    @Override
    public boolean modiUser(MyUser myUser){return MyUserUpdateUtils.myConnextDatabase(myUser);}

    @Override
    public MyUser findUserById(int id) {
        return MyUserOneJDBCUtils.myConnextDatabase(id);
    }

    @Override
    public MyUser findUserNameById(String myusername) {
        return MyUserOneUSNJDBCUtils.myConnextDatabase(myusername);
    }

    @Override
    public boolean changepassword(MyUser myUser) {
        return MyUserUpdatePasswordUtils.myConnextDatabase(myUser);
    }
}
