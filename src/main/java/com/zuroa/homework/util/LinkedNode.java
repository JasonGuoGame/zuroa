package com.zuroa.homework.util;

/**
 * Created by scnyig on 9/12/2017.
 */
public class LinkedNode {
    private String url;
    public LinkedNode next;
    public LinkedNode(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        } else if (obj == this) {
            return true;
        }

        if (obj instanceof LinkedNode) {
            return this.getUrl().equals(((LinkedNode) obj).getUrl());
        }else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getUrl().hashCode();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
