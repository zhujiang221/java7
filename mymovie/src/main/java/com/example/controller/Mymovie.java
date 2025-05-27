package com.example.controller;

import com.example.service.MySearchMovie;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Mymovie {
    //这里把service引入，相当于对应餐厅中调用厨师，把service定义成私有
    private MySearchMovie mymovie=new MySearchMovie();
      @RequestMapping("/movie")
       public String mymovie(){

          return mymovie.search().toString();
      }

}
