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
    Object getArticlesByUserId(int user_id);
    int updateAnArticle(TblArticle tblArticle);
    int deleteAnArticle(String article_id);
}
