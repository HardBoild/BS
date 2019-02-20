package com.jit.service;

import com.jit.pojo.TblUser;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/1/31.
 */
public interface TblUserService {
    public void insertUser(String username,String password,String phone,int role,String email,Date registration_time);
    public String validLogin(String phone,String password);
    public String changePassword(String phone,String password);
    public TblUser getUserByPhone(String phone,String password);
    public int countUserNum();
    public TblUser getUserById(String user_id);
}
