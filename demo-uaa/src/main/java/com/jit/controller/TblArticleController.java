package com.jit.controller;

import com.jit.pojo.TblArticle;
import com.jit.service.TblArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mengyuan.Yu on 2019/2/12.
 */
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblArticle")
@Api(description = "用户旅游心得分享管理")
public class TblArticleController {
    @Autowired
    private TblArticleService tblArticleService;
    @PostMapping("/addNewArticle")
    @ResponseBody
    @ApiOperation("用户新增一篇文章")
    public String addNewArticle(@RequestBody TblArticle tblArticle){
        if(tblArticleService.insertArticle(tblArticle)==1)
            return "success";
        return "failed";
    }
    @PostMapping ("/changeArticleStatus")
    @ResponseBody
    @ApiOperation("管理员修改文章审核状态")
    public String changeArticleStatus(@RequestParam(value = "article_id")int article_id,
                                            @RequestParam(value = "article_status")int article_status)
    {
        if(tblArticleService.changeStatus(article_id,article_status)>0)
            return "success";
        return "failed";
    }



}
