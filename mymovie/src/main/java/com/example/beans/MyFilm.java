package com.example.beans;

import com.alibaba.fastjson.JSONObject;
import netscape.javascript.JSObject;

public class MyFilm {
    private int id;
    private String moviename;
    private String description;
    private String pic;
    private int cateid;
    private String htp;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public MyFilm(int id, String moviename, String description, String pic, int cateid, String htp) {
        this.id = id;
        this.moviename = moviename;
        this.description = description;
        this.pic = pic;
        this.cateid = cateid;
        this.htp = htp;
    }

    public MyFilm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getHtp() {
        return htp;
    }

    public void setHtp(String htp) {
        this.htp = htp;
    }
}
