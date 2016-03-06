package com.example.simpletageview.tagview2.view;

/**
 * Created by lc on 16-3-6.
 */
public class TagBean {
    private boolean check;
    private String tagName;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getTagName() {
        return tagName;
    }

    public TagBean setTagName(String tagName) {
        this.tagName = tagName;
        return this;
    }
}
