package com.jit.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/2/12.
 */
@Component
@EntityScan
public class TblArticle {
    private int article_id;
    private String article_title;
    private String article_abstract;
    private int user_id;
    private String article_body;
    private int like_num;
    private int article_status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    private Date create_time;
    public String getArticle_abstract() {
        return article_abstract;
    }

    public void setArticle_abstract(String article_abstract) {
        this.article_abstract = article_abstract;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getArticle_body() {
        return article_body;
    }

    public void setArticle_body(String article_body) {
        this.article_body = article_body;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public int getArticle_status() {
        return article_status;
    }

    public void setArticle_status(int article_status) {
        this.article_status = article_status;
    }


}
