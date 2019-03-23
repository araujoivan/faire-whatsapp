package com.whatsapp.faire.model;

/**
 *
 * @author eder
 */
public class WhatsappMessageResponse {
    
    private boolean success;
    private String custom_uid;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCustom_uid() {
        return custom_uid;
    }

    public void setCustom_uid(String custom_uid) {
        this.custom_uid = custom_uid;
    }
}
