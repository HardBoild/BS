package com.jit.service;

import com.jit.pojo.TblCaptcha;

import java.util.Date;
import java.util.Map;

/**
 * Created by Mengyuan.Yu on 2019/3/18.
 */
public interface TblCaptchaService {
    public TblCaptcha queryByCaptcha(String captcha);
    public TblCaptcha queryByToken(String token);
    public void save(TblCaptcha token);
    public void update(TblCaptcha token);
    public boolean isExpired(Date expireTime);
    public Map<String, Object> createToken(String captcha);
    public void deleteByToken(String token);
}
