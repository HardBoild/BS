package com.jit.mapper;

import com.jit.pojo.TblArticle;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Mengyuan.Yu on 2019/2/14.
 */
@Repository
public interface TblArticleMapper{
    //User提交文章
    @Insert("INSERT INTO TBL_ARTICLE(article_title,article_abstract,user_id,article_body,like_num,article_status,create_time)VALUES(#{article_title},#{article_abstract},#{user_id},#{article_body},#{like_num},#{article_status},#{create_time})")
    void insertArticle(@Param("article_title")String article_title,
                @Param("article_abstract")String article_abstract,
                @Param("user_id")int user_id,
                @Param("article_body")String article_body,
                @Param("like_num")int like_num,
                @Param("article_status")int article_status,
                @Param("create_time")Date create_time);
    //审核文章
    @Update("UPDATE TBL_ARTICLE SET article_status=#{article_status} WHERE article_id=#{article_id}")
    int changeStatus(@Param("article_id")int article_id,@Param("article_status")int article_status);

    //所有文章
    @Select("SELECT * FROM TBL_ARTICLE WHERE article_status=1 ORDER BY create_time DESC")
    List<TblArticle> getAllArticle();

    //根据条件查询文章
    @Select("SELECT * FROM TBL_ARTICLE WHERE article_abstract  LIKE\"%\"#{condition}\"%\" AND article_status=1 ORDER BY create_time DESC")
    List<TblArticle> getArticlesByCondition(String condition);

    //查询用户自己的文章
    @Select("SELECT * FROM TBL_ARTICLE WHERE user_id = #{user_id} ORDER BY create_time DESC")
    List<TblArticle> getArticlesByUserId(int user_id);

    //编辑文章
    @Update("UPDATE TBL_ARTICLE SET article_title=#{article_title},article_abstract=#{article_abstract},article_body=#{article_body}  WHERE article_status=1 AND article_id=#{article_id}")
    int updateAnArticle(@Param("article_title")String article_title,
                        @Param("article_abstract")String article_abstract,
                        @Param("article_body")String article_body,
                        @Param("article_id")int article_id);

    //删除文章
    @Transactional
    @Delete("DELETE FROM tbl_article WHERE tbl_article.article_id =#{article_id}")
    int deleteArticle(@Param("article_id") String article_id);

}
