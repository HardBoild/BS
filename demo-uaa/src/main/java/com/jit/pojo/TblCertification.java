package com.jit.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
@Component
@EntityScan
public class TblCertification {
    public String getReal_phone() {
        return real_phone;
    }

    public void setReal_phone(String real_phone) {
        this.real_phone = real_phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private int user_id;
    private String real_phone;
}
