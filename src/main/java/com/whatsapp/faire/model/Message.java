/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatsapp.faire.model;

/**
 *
 * @author eder
 */
public class Message {
    
    private String token;
    private String uid;
    private String to;
    private String custom_uid;
    private String text;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getCustom_uid() {
        return custom_uid;
    }

    public void setCustom_uid(String custom_uid) {
        this.custom_uid = custom_uid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
