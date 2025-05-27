package com.example.controller;
import com.example.beans.MyFilm;
import com.example.service.MyCollectInterface;
import com.example.service.MyCollectInterfaceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class MyCollectController {
    private MyCollectInterface myCollectInterface=new MyCollectInterfaceImpl();

    //查
    @RequestMapping("/findcollect")
    public String findcollect(String username){
        return  myCollectInterface.findcollect(username).toString();
    }
    //增
    @RequestMapping("/addcollect")
    public String addcollect(String username, MyFilm myFilm){
        return  myCollectInterface.addcollect(username,myFilm).toString();
    }
    //改
    @RequestMapping("/updatecolllect")
    public String updatecolllect(String username,MyFilm myFilm){
        return  myCollectInterface.updatecollect(username,myFilm).toString();
    }
    //查
    @RequestMapping("delcollect")
    public String delcollect(String username,int delIndex){

        return myCollectInterface.delcollect(username,delIndex).toString();
    }
}
