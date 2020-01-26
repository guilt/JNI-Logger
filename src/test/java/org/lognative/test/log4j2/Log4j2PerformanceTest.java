package org.lognative.test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2PerformanceTest {

    private static final int totalIterations = 2_000_000;

    @Test
    public void testLoggingWithLog4J2LogFile() {
        int numberOfIterations = totalIterations;
        final Logger logger = LogManager.getLogger("LoggerFile");
        final long startTime = System.currentTimeMillis();
        while(numberOfIterations > 0) {
            logger.info("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
            --numberOfIterations;
        }
        final long endTime = System.currentTimeMillis();
        final Logger consoleLogger = LogManager.getLogger("Console");
        consoleLogger.info( "Native" );
        consoleLogger.info( "Start: %d, End: %d, Time for Total: %f\n", startTime, endTime, (endTime - startTime) / 1000.0 );
    }

    @Test
    public void testLoggingWithLog4J2LogFileRegular() {
        int numberOfIterations = totalIterations;
        final Logger logger = LogManager.getLogger("LoggerFileRegular");
        final long startTime = System.currentTimeMillis();
        while(numberOfIterations > 0) {
            logger.info("ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ");
            --numberOfIterations;
        }
        final long endTime = System.currentTimeMillis();
        final Logger consoleLogger = LogManager.getLogger("Console");
        consoleLogger.info( "Native" );
        consoleLogger.info( "Start: %d, End: %d, Time for Total: %f\n", startTime, endTime, (endTime - startTime) / 1000.0 );
    }

}
