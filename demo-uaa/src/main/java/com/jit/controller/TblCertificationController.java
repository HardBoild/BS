package com.jit.controller;

import com.jit.pojo.TblCertification;
import com.jit.service.TblCertificationService;
import com.jit.service.TblUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblCertification")
@Api(description = "用户身份认证管理")
public class TblCertificationController {
    @Autowired
    private TblCertificationService tblCertificationService;
    @PostMapping("/sendMessage")
    @ResponseBody
    @ApiOperation("给用户发送验证码短信")
    public JSONObject sendMessage(@RequestParam(value = "phone") String phone) {
        return tblCertificationService.sendMessage(phone);
    }
    @PostMapping("/addRealPhone")
    @ResponseBody
    @ApiOperation("用户进行实名认证")
    public String addRealPhone(@RequestBody TblCertification tblCertification) {
        tblCertificationService.addRealPhone(tblCertification);
        return "success";

    }
}
