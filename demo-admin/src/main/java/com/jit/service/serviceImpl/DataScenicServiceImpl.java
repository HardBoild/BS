package com.jit.service.serviceImpl;

import com.jit.mapper.DataScenicMapper;
import com.jit.pojo.DataScenic;
import com.jit.service.DataScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Mengyuan.Yu on 2019/2/18.
 */
@Service
public class DataScenicServiceImpl implements DataScenicService{
    @Resource
    private DataScenicMapper dataScenicMapper;
    @Override
    public List<DataScenic> getAllDataScenic() {
        return dataScenicMapper.selectAllScenicInform();
    }
}
