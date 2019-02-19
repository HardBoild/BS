package com.jit.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jit.pojo.TblUser;

/**
 * Created by Mengyuan.Yu on 2019/2/14.
 */
public class JWTUtil {
    public String getToken(TblUser user){
        String token="";
        token= JWT.create().withAudience(user.getPhone())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
