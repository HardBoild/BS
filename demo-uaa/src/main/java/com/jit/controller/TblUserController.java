package com.jit.controller;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.jit.pojo.TblCaptcha;
import com.jit.pojo.TblUser;
import com.jit.service.TblCaptchaService;
import com.jit.service.TblUserService;
import com.jit.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by Mengyuan.Yu on 2019/1/31.
 */
@CrossOrigin
@Controller
@ComponentScan(basePackages = {"com.jit.service"})
@RequestMapping("/TblUser")
@Api(description = "用户基本信息管理")
public class TblUserController {
    private final Logger log = LoggerFactory.getLogger(TblUserController.class);

    @Resource
    private Producer captchaProducer;
    @Autowired
    private TblUserService tblUserService;
    @Autowired
    private  Producer producer;
    @Autowired
    private TblCaptchaService tblCaptchaService;
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
        TblUser userForBase = tblUserService.getUserByPhone(phone, password);
        if(userForBase == null){
            jsonObject.put("message","failed");
            return jsonObject;
        }
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

    @GetMapping("/getUserById")
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

    /**
     *
     *                获取验证码图片
     * @author        Mengyuan.yu
     * @param         request
     * @param         response
     * @return
     * @throws IOException
     */
    @GetMapping("/getCaptchaCode")
    @ResponseBody
    @ApiOperation("获取验证码")
    public void getCaptchaCode(HttpServletRequest request, HttpServletResponse response,@RequestParam(value = "code", required = false) String code) throws IOException{
        HttpSession session = request.getSession();
        response.setDateHeader("Expires", 0);
//        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        //禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        //生成验证码文本
        String capText = captchaProducer.createText();
        //将验证码存入cookie
        Cookie myCookie = new Cookie("myCookie",capText);
        myCookie.setMaxAge(60*2);
        response.addCookie(myCookie);
//        session.setAttribute("myCaptchaCode", capText);
//        log.info("存进session的验证码值为"+request.getSession().getAttribute("myCaptchaCode"));
        log.info("生成验证码文本===="+capText);
        //利用生成的字符串构建图片
        BufferedImage bi = captchaProducer.createImage(capText);
        ImageIO.write(bi, "jpg", response.getOutputStream());
    }

    /**
     *
     *                前端输入的验证码与生成的对比
     * @param         request
     * @param         response
     * @param         captchaCode
     * @Author        Mengyuan.Yu
     */
    @PostMapping("checkCaptchaCode")
    @ResponseBody
    @ApiOperation("校验验证码")
    public JSONObject checkCaptchaCode(HttpServletRequest request, HttpServletResponse response,@RequestParam("captchaCode") String captchaCode) {
        JSONObject jsonObject=new JSONObject();
        log.info("页面输入验证码===="+captchaCode);
        String capText="";
        Cookie []cookies=request.getCookies();
        if(cookies!=null)
            for(Cookie cookie :cookies)
                if(cookie.getName().equals("myCookie")) {
                    capText=cookie.getValue();
                }
        log.info("Cookie中的验证码为"+capText);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        String result = "";
        if(capText.equals(captchaCode)){
            result = "success";
        }else{
            result = "failed";
        }
        log.info(result);
        return jsonObject.put("status",result);
    }


}
