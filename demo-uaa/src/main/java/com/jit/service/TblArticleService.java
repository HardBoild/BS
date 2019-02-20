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
}
