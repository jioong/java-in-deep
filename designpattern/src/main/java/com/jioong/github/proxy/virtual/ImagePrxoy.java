package com.jioong.github.proxy.virtual;

import javax.swing.*;
import java.net.URL;

/**
 * Created by jioong on 17-8-24.
 */
public class ImagePrxoy implements Icon {
    private ImageIcon imageIcon;
    private URL imageUrl;
    private Thread retrievalThread;
    private boolean retrieval = false;

    public int getIconWidth() {
        return 0;
    }

    public int getIconHeight() {
        return 0;
    }

    public void paintIcon() {

    }
}
