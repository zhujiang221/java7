package com.example.controller;
import com.example.beans.MyNewUser;
import com.example.beans.MyUser;
import com.example.service.MyUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//指明这个类是controller
@RestController
@RequestMapping("/")
public class Login {
    private MyUserService myusersevervice = new MyUserService();
    //controller要求返回的参数必须是String
    @RequestMapping("/login")
public  String  login(MyNewUser myuser){

        return myusersevervice.findUser(myuser).toString();
    }

}
