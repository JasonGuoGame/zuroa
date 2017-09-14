package com.zuroa.homework.model.entity;

import com.zuroa.homework.util.PageNode;

import java.util.LinkedList;

/**
 * Created by scnyig on 9/6/2017.
 */
public class User {
    private LinkedList<PageNode> urls = new LinkedList<PageNode>();
    private String name;

    public User(String name) {
        this.name = name;
    }
    //add new pagenode


    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }else if (obj == this) {
            return true;
        }
        if (obj instanceof User) {
            return getName().equals(((User) obj).getName());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
