package org.lognative;

import java.io.File;
import java.io.IOException;

public class NativeFileLogger implements AutoCloseable {

    final String filePath;
    final int fileHandle;

    static {
        System.loadLibrary("nativeimpl");
    }

    public NativeFileLogger(final String filePath) throws IOException {
        this.filePath = filePath;
        fileHandle = openFile(filePath);
        if(fileHandle < 0)
            throw new IOException( String.format("Unable to Open File: %s", filePath) );
    }

    public NativeFileLogger(final File file) throws IOException {
        this(file.getCanonicalPath());
    }

    public native int openFile(final String filePath);

    protected native void logBytesToFile(int fileHandle, final byte []givenBytes, final int offset, final int length);

    public void logBytes(final byte []givenBytes, final int offset, final int length) {
        logBytesToFile( fileHandle, givenBytes, offset, length );
    }

    public void logBytes(final byte []givenBytes) {
        logBytes(givenBytes, 0, givenBytes.length);
    }

    protected native void logToFile(int fileHandle, final String givenString);

    public void log(final String givenString) {
        logToFile( fileHandle, givenString );
    }

    public void log(final String givenStringPattern, final Object ...formatArgs) {
        log(String.format(givenStringPattern, formatArgs));
    }

    protected native void flushFile(int fileHandle);

    public native void flush();

    protected native void closeFile(int fileHandle);

    @Override
    public void close() {
        closeFile( fileHandle );
    }
}
