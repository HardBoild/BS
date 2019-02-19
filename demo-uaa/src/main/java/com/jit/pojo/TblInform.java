package com.jit.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/2/15.
 */
@Component
@EntityScan
public class TblInform {
    private int inform_id;
    private int user_id;
    private String inform_title;
    private String inform_content;
    private Date inform_date;
    private int inform_type;
    public int getInform_id() {
        return inform_id;
    }

    public void setInform_id(int inform_id) {
        this.inform_id = inform_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getInform_title() {
        return inform_title;
    }

    public void setInform_title(String inform_title) {
        this.inform_title = inform_title;
    }

    public String getInform_content() {
        return inform_content;
    }

    public void setInform_content(String inform_content) {
        this.inform_content = inform_content;
    }

    public Date getInform_date() {
        return inform_date;
    }

    public void setInform_date(Date inform_date) {
        this.inform_date = inform_date;
    }

    public int getInform_type() {
        return inform_type;
    }

    public void setInform_type(int inform_type) {
        this.inform_type = inform_type;
    }

}
