package com.example.controller;
import com.example.beans.MyNewUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class MyNewLogin {
    @RequestMapping("/newlogin")
    public String newlogin() {
        MyNewUser mynewuser = new MyNewUser();
        mynewuser.setUsername("zhujiang");
        mynewuser.setPassword("123456");
        //这里值唯一是管理员2为普通用户
        mynewuser.setIdentify(1);
        return  mynewuser.toString();

    }
}
