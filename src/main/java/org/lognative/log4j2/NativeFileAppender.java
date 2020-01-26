package org.lognative.log4j2;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.lognative.NativeFileLogger;

import java.io.Serializable;

@Plugin(
        name="NativeFileAppender",
        category= Core.CATEGORY_NAME,
        elementType = Appender.ELEMENT_TYPE
)
public class NativeFileAppender extends AbstractAppender  {

    protected final NativeFileLogger nativeLogger;

    protected NativeFileAppender(String fileName, String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions, Property[] properties) {
        super( name, filter, layout, ignoreExceptions, properties );
        nativeLogger = new NativeFileLogger( fileName );
    }

    @PluginFactory
    public static NativeFileAppender createAppender(
            @PluginAttribute("fileName") String fileName,
            @PluginAttribute("name") String name,
            @PluginElement("Filter") Filter filter,
            @PluginElement("Layout") Layout layout
            ) {
        return new NativeFileAppender(fileName, name, filter, layout, true, Property.EMPTY_ARRAY);
    }

    @Override
    public void append(LogEvent event) {
        nativeLogger.logBytes(getLayout().toByteArray( event ));
    }

}
