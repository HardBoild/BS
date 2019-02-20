package com.jit.service;

import com.jit.pojo.DataScenic;
import com.jit.pojo.TblInform;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by Mengyuan.Yu on 2019/2/18.
 */
public interface DataScenicService {
    List<DataScenic> getAllDataScenic();
    void getProvinceAndPeopleNum(String pp[][]);
}
