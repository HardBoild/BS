package com.jit.pojo;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import java.math.BigInteger;
import java.util.Date;

/**
 * User base information
 * Author: Mengyuan.Yu
 * Created by Mengyuan.Yu on 2019/1/16.
 */
@Component
@EntityScan
public class TblUser {

    private int user_id;
    private String username;
    private String password;
    private String phone;
    private int role;
    private String email;
    private Date registration_time;
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public int getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
    }

}
