package com.jit.controller;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jit.pojo.TblUser;
import com.jit.service.TblUserService;
import com.jit.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/1/31.
 */
@CrossOrigin
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblUser")
@Api(description = "用户基本信息管理")
public class TblUserController {
    @Autowired
    private TblUserService tblUserService;
    @PostMapping("/register")
    @ResponseBody
    @ApiOperation("新增一条用户")
    public int insertUser(@RequestBody TblUser tblUser)
    {
        tblUserService.insertUser(tblUser.getUsername(),tblUser.getPassword(),tblUser.getPhone(),tblUser.getRole(),tblUser.getEmail(),new Date());
        return 1;
    }
    @GetMapping("/login")
    @ResponseBody
    @ApiOperation("登录校验")
    public Object validLogin(@RequestParam String phone,@RequestParam String password)
    {
        JSONObject jsonObject = new JSONObject();
        JWTUtil jwtUtil=new JWTUtil();
        TblUser userForBase = tblUserService.getUserByPhone(phone, password);
        if(userForBase == null){
            jsonObject.put("message","failed");
            return jsonObject;
        }
        String token = jwtUtil.getToken(userForBase);
        jsonObject.put("token", token);
        jsonObject.put("user", userForBase);
        return jsonObject;
    }

    @PutMapping("/changePassword")
    @ResponseBody
    @ApiOperation("用户修改密码")
    public String changePassword(@RequestParam String phone,@RequestParam String password)
    {
        return tblUserService.changePassword(phone,password);
    }

    @GetMapping("/countUserNum")
    @ResponseBody
    @ApiOperation("获取所有用户量")
    public int countUserNum()
    {
        return tblUserService.countUserNum();
    }

    @PostMapping("/getUserById")
    @ResponseBody
    @ApiOperation("通过用户id获取该用户的所有信息")
    public Object getUserById(@RequestParam(value = "user_id") String user_id){
        return tblUserService.getUserById(user_id);
    }

    @PostMapping("/updateUser")
    @ResponseBody
    @ApiOperation("更改个人信息")
    public  int updateUser(@RequestBody TblUser tblUser) {
        System.out.println(tblUser.getUsername()+tblUser.getEmail());
        return tblUserService.updateUser(tblUser);
    }
}
