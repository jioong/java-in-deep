package com.jioong.github.adapter;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by jioong on 17-8-21.
 */
public class EnumeratorIterator implements Iterator {

    private Enumeration enumeration;

    public EnumeratorIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public Object next() {
        return enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
