package com.jit.service.serviceImpl;

import com.jit.mapper.DataScenicMapper;
import com.jit.pojo.DataScenic;
import com.jit.pojo.TblInform;
import com.jit.service.DataScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Hashtable;
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

    //使用Hashtable的原因是因为Hashmap是线程不安全的，Hashtable是线程安全的
    @Override
    public void getProvinceAndPeopleNum(String pp[][]) {
        //Hashtable hashtable=new Hashtable();
        //String pp[][]=new String[34][2];
        String ProvinceName []= {
                "北京","天津","上海","重庆","河北","山西","辽宁","吉林","黑龙江",
                "江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东",
                "海南","四川","贵州","云南","陕西","甘肃","青海","台湾","内蒙",
                "广西","西藏","宁夏","新疆","香港","澳门"};
        for(int i = 0;i<ProvinceName.length;i++){
            List<DataScenic> list = dataScenicMapper.selectLikeProvince(ProvinceName[i]);
            if(list == null){
                //hashtable.put(ProvinceName[i],0);
                pp[i][0]=ProvinceName[i];
                pp[i][1]= "0";
                continue;
            }
            int num=0;//用来计算每个省去了多少人
            for(int j = 0;j<list.size();j++)
                num+= Integer.parseInt(list.get(j).getItemNum());
            //hashtable.put(ProvinceName[i],num);
            pp[i][0]=ProvinceName[i];
            pp[i][1]= num+"";
        }
    }

}
