package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SeleniumTakeScreenshot {
    private static final Logger logger = LogManager.getLogger(SeleniumTakeScreenshot.class);

    public static void main(String[] args) {
        System.out.println("Hello, user!");
        logger.trace("We've just greeted the user!");
        logger.debug("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.warn("We've just greeted the user!");
        logger.info("We've just greeted the user!");
        logger.fatal("We've just greeted the user!");
    }
}
