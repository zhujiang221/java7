package com.example.beans;
import com.alibaba.fastjson.JSONObject;
public class Movied {
    //电影照片
    private String pic;
    //电影主标题
    private  String title;
    //电影描述
    private  String description;
    //有参
    public Movied(String pic, String title, String description) {
        this.pic = pic;
        this.title = title;
        this.description = description;
    }
    //无参
    public Movied() {
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
