package com.jit.service.impl;

import cn.hutool.json.JSONObject;
import com.jit.mapper.TblArticleMapper;
import com.jit.pojo.TblArticle;
import com.jit.service.TblArticleService;
import com.jit.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<TblArticle> getAllArticle() {
        return tblArticleMapper.getAllArticle();
    }

    @Override
    public Object getArticlesByCondition(String condition) {
        List<TblArticle> list=tblArticleMapper.getArticlesByCondition(condition);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articlesByCondition",list);
        return jsonObject;
    }

    @Override
    public Object getArticlesByUserId(int user_id) {
        List<TblArticle> list=tblArticleMapper.getArticlesByUserId(user_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articleByUserId",list);
        return jsonObject;
    }

    @Override
    public int updateAnArticle(TblArticle tblArticle) {
        return tblArticleMapper.updateAnArticle(tblArticle.getArticle_title(),tblArticle.getArticle_abstract(),tblArticle.getArticle_body(),tblArticle.getArticle_id());
    }

    @Override
    public int deleteAnArticle(String article_id) {
        //String temp = article_id.replace(",","','");
        //article_id="\'"+article_id+"\'";
        System.out.println(article_id);
        return tblArticleMapper.deleteAnArticle(article_id);
    }
}
