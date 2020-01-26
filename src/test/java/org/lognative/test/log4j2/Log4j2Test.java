package org.lognative.test.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4j2Test {
    @Test
    public void testLoggingWithLog4J2Console() {
        final Logger logger = LogManager.getLogger("LoggerConsole");
        logger.info( "Info Logging" );
        logger.error( "Error Logging" );
    }

}
