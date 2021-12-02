package com.gittigidiyor.pages;

import java.util.logging.Logger;

public class Log4j {

    private static Logger logger = Logger.getLogger(Log4j.class.getName());


    //Info
    public static void info(String message) {
        logger.info(message);
    }

    //Warn
    public static void warn(String message) {
        logger.warning(message);
    }
}
