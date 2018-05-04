package com.rodrigo.turingmachines.objects;

public class BeltItem {

    private String text;
    private String currentStatus;

    public BeltItem() {
    }

    public BeltItem(String text, String currentStatus) {
        this.text = text;
        this.currentStatus = currentStatus;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
