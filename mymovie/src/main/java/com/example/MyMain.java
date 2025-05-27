package com.example;
//主类标记
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//加上SprintBoot的标记
@SpringBootApplication  // 标记这是一个Spring Boot应用的主类
public class MyMain {
    // 主方法，程序的入口
    public static void main(String[] args) {
        //这里传入一个类名和参数名
        SpringApplication.run(MyMain.class,args);  // 启动Spring Boot应用
    }
}
