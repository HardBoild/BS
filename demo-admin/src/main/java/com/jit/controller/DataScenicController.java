package com.jit.controller;

import cn.hutool.json.JSONObject;
import com.jit.service.DataScenicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mengyuan.Yu on 2019/2/18.
 */
@CrossOrigin
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/DataScenic")
@Api(description = "爬取数据管理")
public class DataScenicController {
    @Autowired
    private DataScenicService dataScenicService;
    @GetMapping("/getAllDataScenic")
    @ResponseBody
    @ApiOperation("获取所有景点信息")
    public Object getAllDataScenic(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("dataScenic",dataScenicService.getAllDataScenic());
        return jsonObject;
    }

    @GetMapping("/getProvinceAndPeopleNum")
    @ResponseBody
    @ApiOperation("二维数组获取省----点评过人数")
    public Object getProvinceAndPeopleNum(){
        String pp[][]=new String[34][2];
        dataScenicService.getProvinceAndPeopleNum(pp);
        return pp;
    }

}
