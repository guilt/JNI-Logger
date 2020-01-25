package org.lognative;

public class NativeLogger {

    static {
        System.loadLibrary("nativeimpl");
    }

    public native void logBytes(final byte []givenBytes, final int offset, final int length);

    public void logBytes(final byte []givenBytes) {
        logBytes(givenBytes, 0, givenBytes.length);
    }

    public native void log(final String givenString);

    public native void flush();

    public void log(final String givenStringPattern, final Object ...formatArgs) {
        log(String.format(givenStringPattern, formatArgs));
    }

}