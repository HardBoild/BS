package com.jit.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * Created by Mengyuan.Yu on 2019/2/18.
 */
@Component
@EntityScan
public class DataScenic {
    private String itemId;
    private String itemHref;
    private String itemImg;
    private String itemTitle;
    private String itemProvince;
    private String itemLocal;
    private String itemPrice;
    private String itemCommentLevel;
    private String itemNum;

    public String getItemLocal() {
        return itemLocal;
    }

    public void setItemLocal(String itemLocal) {
        this.itemLocal = itemLocal;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemHref() {
        return itemHref;
    }

    public void setItemHref(String itemHref) {
        this.itemHref = itemHref;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getItemProvince() {
        return itemProvince;
    }

    public void setItemProvince(String itemProvince) {
        this.itemProvince = itemProvince;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCommentLevel() {
        return itemCommentLevel;
    }

    public void setItemCommentLevel(String itemCommentLevel) {
        this.itemCommentLevel = itemCommentLevel;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

}
