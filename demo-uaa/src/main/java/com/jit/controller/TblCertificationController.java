package com.jit.controller;

import com.jit.pojo.TblCertification;
import com.jit.service.TblCertificationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblCertification")
public class TblCertificationController {
    @Autowired
    private TblCertificationService tblCertificationService;

    @PostMapping("/addRealPhone")
    @ResponseBody
    @ApiOperation("用户进行实名认证")
    public String addRealPhone(@RequestBody TblCertification tblCertification){
        tblCertificationService.addRealPhone(tblCertification);
        return "success";

    }
}
