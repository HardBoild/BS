package com.jit.service.impl;
import com.jit.mapper.TblUserMapper;
import com.jit.pojo.TblUser;
import com.jit.service.TblUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/1/31.
 */
@Service
public class TblUserServiceImpl implements TblUserService {
    @Resource
    private TblUserMapper tblUserMapper;
    @Override
    public TblUser getUserByPhone(String phone, String password){
        //System.out.println(tblUserMapper.findByPhone(phone,password).getRegistration_time());
        return tblUserMapper.findByPhone(phone,password);
    }

    @Override
    public int countUserNum() {
        return tblUserMapper.countUserNum();
    }

    @Override
    public TblUser getUserById(String user_id) {
        return tblUserMapper.getUserById(user_id);
    }

    @Override
    public void insertUser(String username,String password,String phone,int role,String email,Date registration_time) {
        tblUserMapper.insert(username,password,phone,role,email,registration_time);
    }

    @Override
    public String validLogin(String phone, String password) {
        TblUser tblUser=tblUserMapper.findByPhone(phone,password);
        if(tblUser!=null) return "success";
        return "failed";
    }

    @Override
    public String changePassword(String phone, String password) {
        if( tblUserMapper.changePassword(phone,password)==1)
            return "success";
        return "failed";
    }
}
