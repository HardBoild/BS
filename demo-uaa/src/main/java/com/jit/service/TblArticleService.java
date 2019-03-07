package com.jit.service;

import com.jit.pojo.TblArticle;

import java.util.List;

/**
 * Created by Mengyuan.Yu on 2019/2/14.
 */
public interface TblArticleService {
    int insertArticle(TblArticle tblArticle);
    int changeStatus(int article_id,int status);
    List<TblArticle> getAllArticle();
    Object getArticlesByCondition(String condition);
    List getArticlesByUserId(int user_id);
    int updateAnArticle(TblArticle tblArticle);
    int deleteArticles(String[] article_id);
}
