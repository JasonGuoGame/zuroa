package com.zuroa.homework.util;

import com.zuroa.homework.model.entity.User;

/**
 * Created by scnyig on 9/6/2017.
 */
public class PageNode {
    private User user;
    private String url;
    private String timestamp;

    public PageNode(User user, String url) {
        this.user = user;
        this.url = url;
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
