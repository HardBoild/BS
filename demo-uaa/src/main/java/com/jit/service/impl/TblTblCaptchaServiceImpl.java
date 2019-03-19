package com.jit.service.impl;

import com.jit.mapper.TblCaptchaMapper;
import com.jit.pojo.TblCaptcha;
import com.jit.service.TblCaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mengyuan.Yu on 2019/3/18.
 */
@Service
public class TblTblCaptchaServiceImpl implements TblCaptchaService {
    @Autowired
    private TblCaptchaMapper tblCaptchaMapper;
    //1小时后过期
    private final static int EXPIRE = 3600 * 1;

    @Override
    public TblCaptcha queryByCaptcha(String captcha) {
        return tblCaptchaMapper.queryByCaptcha(captcha);
    }

    @Override
    public TblCaptcha queryByToken(String token) {
        return tblCaptchaMapper.queryByToken(token);
    }

    @Override
    public void save(TblCaptcha tblCaptcha){
        tblCaptchaMapper.save(tblCaptcha.getUser_id(),tblCaptcha.getToken(),tblCaptcha.getCaptcha(),tblCaptcha.getExpireTime(),new Date());
    }

    @Override
    public void update(TblCaptcha tblCaptcha){
        tblCaptchaMapper.update(tblCaptcha.getUser_id(),tblCaptcha.getToken(),tblCaptcha.getCaptcha(),tblCaptcha.getExpireTime(),new Date());
    }

    @Override
    public boolean isExpired(Date expireTime){
        Date d=new Date();
        return d.getTime()>expireTime.getTime()?true:false;
    }

    @Override
    public Map<String, Object> createToken(String captcha) {
        //生成一个token
        String token = UUID.randomUUID().toString();
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        TblCaptcha tokenEntity = queryByCaptcha(captcha);
        if(tokenEntity == null){
            tokenEntity = new TblCaptcha();
            tokenEntity.setCaptcha(captcha);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            save(tokenEntity);
        }else{
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            update(tokenEntity);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }

    @Override
    public void deleteByToken(String token) {
        tblCaptchaMapper.deleteByToken(token);
    }
}
