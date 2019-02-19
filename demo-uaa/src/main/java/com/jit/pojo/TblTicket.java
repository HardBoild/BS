package com.jit.pojo;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

/**
 * Created by Mengyuan.Yu on 2019/2/15.
 */
public class TblTicket {
    private int ticket_id;
    private int user_idA;
    private int user_idB;
    private String description;
    private int ticket_status;
    private int review_status;

    public int getUser_idB() {
        return user_idB;
    }

    public void setUser_idB(int user_idB) {
        this.user_idB = user_idB;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getUser_idA() {
        return user_idA;
    }

    public void setUser_idA(int user_idA) {
        this.user_idA = user_idA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(int ticket_status) {
        this.ticket_status = ticket_status;
    }

    public int getReview_status() {
        return review_status;
    }

    public void setReview_status(int review_status) {
        this.review_status = review_status;
    }

}
