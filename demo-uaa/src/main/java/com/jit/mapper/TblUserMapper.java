package com.jit.mapper;

import com.jit.pojo.TblUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/1/31.
 */
@Repository
public interface TblUserMapper {
    //register
    @Insert("INSERT INTO TBL_USER(username,password,phone,role,email,registration_time)VALUES(#{username},#{password},#{phone},#{role},#{email},#{registration_time})")
    void insert(@Param("username") String username,
               @Param("password") String password,
               @Param("phone") String phone,
               @Param("role") int role,
               @Param("email") String email,
               @Param("registration_time") Date registration_time);

    //login
    @Select("SELECT * FROM TBL_USER WHERE phone = #{phone} AND password = #{password}")
    TblUser findByPhone(@Param("phone") String phone,@Param("password") String password);

    //change password
    @Update("UPDATE TBL_USER SET password = #{password} WHERE phone = #{phone}")
    int changePassword(@Param("phone") String phone,@Param("password") String password);

    //count user num
    @Select("SELECT Count(tbl_user.role) FROM tbl_user WHERE role = 1")
    int countUserNum();

}
