package com.github.jioong.basic.logging;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by jioong on 17-5-15.
 */
public class App {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.toString());
        Logger root = Logger.getLogger("root");
        root.setLevel(Level.WARNING);
        logger.setLevel(Level.INFO);
        logger.setParent(root);
        logger.setFilter(new Filter() {
            public boolean isLoggable(LogRecord record) {
                return true;
            }
        });

        LogRecord record = new LogRecord(Level.INFO, "file handle");
        try {
            FileHandler fileHandler = new FileHandler();
            fileHandler.publish(record);

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Info: nice to meet you");
        logger.warning("Warn: look out");
        logger.log(Level.WARNING, "Warning: use setting");


    }
}
