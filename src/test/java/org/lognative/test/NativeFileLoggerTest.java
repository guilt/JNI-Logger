package org.lognative.test;

import org.junit.Before;
import org.junit.Test;
import org.lognative.NativeFileLogger;

public class NativeFileLoggerTest {

    private static final String logFileName = "test.log";

    @Before
    public void setUp() {
        new NativeFileLogger(logFileName);
    }

    @Test
    public void testBasicLogging() {
        new NativeFileLogger(logFileName).log("Basic String Test");
    }

    @Test
    public void testBasicLoggingBytes() {
        new NativeFileLogger(logFileName).logBytes("Basic Bytes Test\n".getBytes());
    }

    @Test
    public void testLoggingWithFormatting() {
        new NativeFileLogger(logFileName).log("Arguments: %s %d", "Test", 42);
    }

}
