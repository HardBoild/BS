package com.jit.service.serviceImpl;

import com.jit.mapper.TblInformMapper;
import com.jit.pojo.TblInform;
import com.jit.service.TblInformService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Mengyuan.Yu on 2019/2/20.
 */
@Service
public class TblInformServiceImpl implements TblInformService{
    @Resource
    private TblInformMapper tblInformMapper;
    @Override
    public void addAnInform(TblInform tblInform) {
        tblInformMapper.addAnInform(tblInform.getUser_id(),tblInform.getInform_title(),tblInform.getInform_content(),new Date(),tblInform.getInform_type());
    }
}
