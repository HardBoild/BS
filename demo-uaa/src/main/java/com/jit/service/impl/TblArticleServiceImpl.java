package com.jit.service.impl;

import com.jit.mapper.TblArticleMapper;
import com.jit.pojo.TblArticle;
import com.jit.service.TblArticleService;
import com.jit.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by Mengyuan.Yu on 2019/2/14.
 */
@Service
public class TblArticleServiceImpl implements TblArticleService{
    @Autowired
    private TblArticleMapper tblArticleMapper;

    @Override
    public int insertArticle(TblArticle tblArticle) {
        tblArticleMapper.insertArticle(tblArticle.getArticle_title(),tblArticle.getArticle_abstract(),tblArticle.getUser_id(),tblArticle.getArticle_body(),tblArticle.getLike_num(),0);
        return 1;
    }

    @Override
    public int changeStatus(int article_id, int article_status) {
        return tblArticleMapper.changeStatus(article_id,article_status);
    }
}
