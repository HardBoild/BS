package com.jit.mapper;

import com.jit.pojo.DataScenic;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mengyuan.Yu on 2019/2/18.
 */
@Repository
public interface DataScenicMapper {
    @Select("SELECT * FROM DATA_SCENIC ")
    List<DataScenic> selectAllScenicInform();
    //带地址查询条件，模糊查询，查出所有带地址条件的
    @Select("SELECT * FROM DATA_SCENIC WHERE data_scenic.itemProvince LIKE\"%\"#{provinceName}\"%\"")
    List<DataScenic> selectLikeProvince(String provinceName);
}
