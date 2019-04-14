package com.jit.mapper;

import com.jit.pojo.TblCertification;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
@Repository
public interface TblCertificationMapper {
    @Select("SELECT * FROM TBL_CERTIFICATION WHERE user_id=#{user_id}")
    TblCertification findRealPhone(int user_id);
    @Insert("INSERT INTO TBL_CERTIFICATION (user_id,real_phone) VALUES (#{user_id},#{real_phone})")
    void addRealPhone(@Param(value = "user_id")int user_id,@Param(value = "real_phone") String real_phone);
    @Update("UPDATE TBL_CERTIFICATION real_phone=#{real_phone} WHERE user_id=#{user_id}")
    void updateRealPhone(int user_id,String real_phone);
    @Delete("DELETE * FROM TBL_CERTIFICATION WHERE user_id=#{user_id}")
    void deleteRealPhone(int user_id,String real_phone);

}
