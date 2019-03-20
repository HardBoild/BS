package com.jit.service;

import com.jit.pojo.TblCertification;

/**
 * Created by Mengyuan.Yu on 2019/3/20.
 */
public interface TblCertificationService {
    TblCertification findRealPhone(int user_id);
    void addRealPhone(TblCertification tblCertification);
    void updateRealPhone(TblCertification tblCertification);
    void deleteRealPhone(TblCertification tblCertification);
}
