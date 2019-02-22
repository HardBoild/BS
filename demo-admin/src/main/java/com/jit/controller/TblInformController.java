package com.jit.controller;

import com.jit.pojo.TblInform;
import com.jit.service.TblInformService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by Mengyuan.Yu on 2019/2/20.
 */
@CrossOrigin
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblInform")
public class TblInformController {
    @Autowired
    private TblInformService tblInformService;
    @GetMapping("/addAnInform")
    @ResponseBody
    @ApiOperation("给用户发送一条信息")
    public void postAnInform(@RequestBody TblInform tblInform){
        tblInformService.addAnInform(tblInform);
    }

}
