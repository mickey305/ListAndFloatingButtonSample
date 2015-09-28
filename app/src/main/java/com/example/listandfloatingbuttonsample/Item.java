package com.example.listandfloatingbuttonsample;

public class Item {
    String title;
    String subTitle;
    boolean completed;

    public Item(String title, String subTitle, boolean completed) {
        this.setTitle(title);
        this.setSubTitle(subTitle);
        this.setCompleted(completed);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
