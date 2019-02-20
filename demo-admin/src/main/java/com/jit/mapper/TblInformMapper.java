package com.jit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/2/20.
 */
@Repository
public interface TblInformMapper {
    //给用户发送一条信息
    @Insert("INSERT INTO TBL_INFORM(user_id,inform_title,inform_content,inform_date,inform_type) VALUES (#{user_id},#{inform_title},#{inform_content},#{inform_date},#{inform_type})")
    void addAnInform(int user_id, String inform_title, String inform_content, Date inform_date,int inform_type);
}
