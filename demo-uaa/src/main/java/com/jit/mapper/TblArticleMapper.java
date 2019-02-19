package com.jit.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by Mengyuan.Yu on 2019/2/14.
 */
@Repository
public interface TblArticleMapper {
    //User提交文章
    @Insert("INSERT INTO TBL_ARTICLE(article_title,article_abstract,user_id,article_body,like_num,article_status)VALUES(#{article_title},#{article_abstract},#{user_id},#{article_body},#{like_num},#{article_status})")
    void insertArticle(@Param("article_title")String article_title,
                @Param("article_abstract")String article_abstract,
                @Param("user_id")int user_id,
                @Param("article_body")String article_body,
                @Param("like_num")int like_num,
                @Param("article_status")int article_status);
    //审核文章
    @Update("UPDATE TBL_ARTICLE SET article_status=#{article_status} WHERE article_id=#{article_id}")
    int changeStatus(@Param("article_id")int article_id,@Param("article_status")int article_status);
}
