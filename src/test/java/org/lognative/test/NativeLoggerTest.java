package org.lognative.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.lognative.NativeLogger;

public class NativeLoggerTest {

    @Before
    public void setUp() {
        new NativeLogger();
    }

    @Test
    public void testBasicLogging() {
        new NativeLogger().log("Basic String Test");
    }

    @Test
    public void testBasicLoggingBytes() {
        new NativeLogger().logBytes("Basic Bytes Test\n".getBytes());
    }

    @Test
    public void testLoggingWithFormatting() {
        new NativeLogger().log("Arguments: %s %d", "Test", 42);
    }

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
