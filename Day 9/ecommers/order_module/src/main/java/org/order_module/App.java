package org.order_module;

import org.order_module.utils.ConnectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Starting application...");

        try {
            var connection = ConnectionUtils.getConnection();
            logger.info("Database connection established: {}", connection);
        } catch (Exception e) {
            logger.error("Error while connecting to database", e);
        }

        logger.debug("Application finished execution.");
    }
}
