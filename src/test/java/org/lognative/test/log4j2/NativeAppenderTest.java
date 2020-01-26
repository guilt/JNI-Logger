package org.lognative.test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class NativeAppenderTest {
    @Test
    public void testLoggingWithLog4J2() {
        final Logger logger = LogManager.getLogger();
        logger.info( "Info Logging" );
        logger.error( "Error Logging" );
    }

    @Test
    public void testLoggingWithLog4J2Regular() {
        final Logger logger = LogManager.getLogger("LoggerRegular");
        logger.info( "Info Logging" );
        logger.error( "Error Logging" );
    }
}
