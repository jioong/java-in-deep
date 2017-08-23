package com.jioong.github.iterator;

import java.util.Iterator;

/**
 * Created by jioong on 17-8-22.
 */
public class DinerMenuItemIterator implements Iterator {
    private MenuItem[] items;
    private int position = 0;

    public DinerMenuItemIterator(MenuItem[] items) {
        this.items = items;
    }

    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    public Object next() {
        MenuItem item = items[position];
        position += 1;
        return item;
    }

    public void remove() {

    }
}
