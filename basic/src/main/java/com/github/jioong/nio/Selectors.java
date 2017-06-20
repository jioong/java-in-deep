package com.github.jioong.nio;

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Set;

/**
 * Created by jioong on 17-6-20.
 */
public class Selectors {

    public static void main(String[] args) {

    }

    public static void select(Selector selector) {
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        for (SelectionKey selectionKey : selectionKeys) {
            SelectableChannel channel = selectionKey.channel();

        }
    }
}
