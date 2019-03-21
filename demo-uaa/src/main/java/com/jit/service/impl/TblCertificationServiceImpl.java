package com.jit.service.impl;

import com.jit.mapper.TblCertificationMapper;
import com.jit.pojo.TblCertification;
import com.jit.service.TblCertificationService;
import com.jit.util.RandomNumberUtils;
import com.jit.util.SendMessageUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
@Service
public class TblCertificationServiceImpl implements TblCertificationService {
    @Autowired
    private TblCertificationMapper tblCertificationMapper;

    @Override
    public TblCertification findRealPhone(int user_id) {
        return tblCertificationMapper.findRealPhone(user_id);
    }

    @Override
    public void addRealPhone(TblCertification tblCertification) {
        tblCertificationMapper.addRealPhone(tblCertification.getUser_id(),tblCertification.getReal_phone());
    }

    @Override
    public void updateRealPhone(TblCertification tblCertification) {
        tblCertificationMapper.updateRealPhone(tblCertification.getUser_id(),tblCertification.getReal_phone()
        );
    }

    @Override
    public void deleteRealPhone(TblCertification tblCertification) {
        tblCertificationMapper.deleteRealPhone(tblCertification.getUser_id(),tblCertification.getReal_phone());
    }

    @Override
    public JSONObject sendMessage(String phone) {
        JSONObject jsonObject = null;
        JSONObject result =new JSONObject();
        String yzmText= RandomNumberUtils.getNonce_str(4);
        jsonObject= SendMessageUtils.mobileQuery(phone,yzmText);
        if(null!=jsonObject &&jsonObject.get("count").equals(1)){
            result.put("phone",phone);
            result.put("yzm",yzmText);
            result.put("status","success");
        }
        else{
            result.put("phone","");
            result.put("yzm","");
            result.put("status","failed");
        }
        return result;
    }
}
