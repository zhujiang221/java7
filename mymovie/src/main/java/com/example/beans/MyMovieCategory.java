package com.example.beans;
import com.alibaba.fastjson.JSONObject;
public class MyMovieCategory {
    private int id;
    private int cateid;
    private String moviename;
    private String description;
    private String pic;
    private String catename;
    public MyMovieCategory(int id, int cateid, String moviename, String description, String pic,String catename) {
        this.id = id;
        this.cateid = cateid;
        this.moviename = moviename;
        this.description = description;
        this.pic = pic;
        this.catename=catename;
    }
    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }

    public String getCatename() {
        return catename;
    }
    public void setCatename(String catename) {
        this.catename = catename;
    }
    public MyMovieCategory() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
