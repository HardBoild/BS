package com.jit.controller;

import cn.hutool.json.JSONObject;
import com.jit.pojo.TblArticle;
import com.jit.service.TblArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;

/**
 * Created by Mengyuan.Yu on 2019/2/12.
 */
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblArticle")
@Api(description = "用户旅游心得分享管理")
public class TblArticleController {
    @Resource
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
                                            @RequestParam(value = "article_status")int article_status) {
        if(tblArticleService.changeStatus(article_id,article_status)>0)
            return "success";
        return "failed";
    }
    @GetMapping("/getAllArticle")
    @ResponseBody
    @ApiOperation("获取所有用户文章")
    public Object getAllArticle(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("articleList",tblArticleService.getAllArticle());
        return jsonObject;
    }

    @PostMapping("/getArticlesByCondition")
    @ResponseBody
    @ApiOperation("带条件查询部分随笔")
    public Object getArticlesByCondition(String condition){
        return tblArticleService.getArticlesByCondition(condition);
    }

    @GetMapping("/getArticlesByUserId")
    @ResponseBody
    @ApiOperation("获取一个用户下的所有文章")
    public List getArticlesByUserId(@RequestParam(value = "user_id")int user_id){
        return tblArticleService.getArticlesByUserId(user_id);
    }

    @PostMapping("/updateAnArticle")
    @ResponseBody
    @ApiOperation("更新一篇文章")
    public int updateAnArticle(@RequestBody TblArticle tblArticle){
        return tblArticleService.updateAnArticle(tblArticle);
    }
    @PostMapping("/deleteArticles")
    @ResponseBody
    @ApiOperation("批量删除文章")
    public int deleteArticles(@RequestParam("id") String[] article_ids){
        return tblArticleService.deleteArticles(article_ids);
    }

}
