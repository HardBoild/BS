package com.jit.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * Created by Mengyuan.Yu on 2019/2/12.
 */
@Component
@EntityScan
public class TblScenic {

    private int scenic_id;
    private String scenicName;
    private String scenicAddress;
    private String scenicStar;
    public int getScenic_id() {
        return scenic_id;
    }

    public void setScenic_id(int scenic_id) {
        this.scenic_id = scenic_id;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getScenicAddress() {
        return scenicAddress;
    }

    public void setScenicAddress(String scenicAddress) {
        this.scenicAddress = scenicAddress;
    }

    public String getScenicStar() {
        return scenicStar;
    }

    public void setScenicStar(String scenicStar) {
        this.scenicStar = scenicStar;
    }


}
