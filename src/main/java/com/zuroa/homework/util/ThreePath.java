package com.zuroa.homework.util;

import java.util.Objects;

/**
 * Created by scnyig on 9/6/2017.
 */
public class ThreePath {
    private LinkedNodes threePath;

    public ThreePath(LinkedNodes threePath) {
        this.threePath = threePath;
    }
    public LinkedNodes getThreePath() {
        return threePath;
    }

    public void setThreePath(LinkedNodes threePath) {
        this.threePath = threePath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(threePath.getHead(), threePath.getHead().next, threePath.getTail());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }else if (obj == this) {
            return true;
        }
        if(obj instanceof ThreePath) {
            boolean headE = this.getThreePath().getHead().equals(((ThreePath) obj).getThreePath().getHead());
            boolean headS = this.getThreePath().getHead().next.equals(((ThreePath) obj).getThreePath().getHead().next);
            boolean headT = this.getThreePath().getTail().equals(((ThreePath) obj).getThreePath().getTail());
            return headE && headS && headT;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return getThreePath().getHead().getUrl() + "->" + getThreePath().getHead().next.getUrl() + "->" + getThreePath().getTail().getUrl();
    }
}
