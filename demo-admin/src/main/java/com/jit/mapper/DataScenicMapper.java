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
}
