package com.zuroa.homework.util;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by scnyig on 9/14/2017.
 */
public class ValueComparator implements Comparator<ThreePath> {
    Map<ThreePath, Integer> base;

    public ValueComparator(Map<ThreePath, Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
    @Override
    public int compare(ThreePath a, ThreePath b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
