package com.jit.mapper;

import com.jit.pojo.TblCaptcha;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/3/19.
 */
@Repository
public interface TblCaptchaMapper {
    @Select("SELECT * From TBL_CAPTCHA WHERE captcha=#{captcha}")
    TblCaptcha queryByCaptcha(String captcha);
    @Select("SELECT * FROM TBL_CAPTCHA WHERE token=#{token}")
    TblCaptcha queryByToken(String token);
    @Delete("DELETE * FROM TBL_CAPTCHA WHERE token=#{token}")
    void deleteByToken(String token);
    @Insert("INSERT INTO TBL_CAPTCHA (user_id,token,captcha,expireTime,updateTime) VALUES (#{user_id},#{token},#{captcha},#{expireTime},#{updateTime}})")
    void save(int user_id,String token,String captcha,Date expireTime,Date updateTime);
    @Update("UPDATE TBL_CAPTCHA token=#{token},captcha=#{captcha},expireTime=#{expireTime},updateTime=#{updateTime} WHERE user_id=#{user_id}")
    void update(int user_id,String token,String captcha,Date expireTime,Date updateTime);

}
