#include "jni.h"
#include "NativeFileLogger.h"
#include "org_lognative_NativeFileLogger.h"

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_logToFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle, jstring givenString)
{
  const char *rawString = jniEnvironment->GetStringUTFChars(givenString, JNI_FALSE);
  //XXX: TODO
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_logBytesToFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle, jbyteArray givenBytes, jint offset, jint length)
{
  jbyte* rawBytes = jniEnvironment->GetByteArrayElements(givenBytes, JNI_FALSE);
  //XXX: TODO
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_flushFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle)
{
  //XXX: TODO
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_closeFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle)
{
  //XXX: TODO
}

JNIEXPORT jint JNICALL Java_org_lognative_NativeFileLogger_openFile(JNIEnv *jniEnvironment, jobject thisObject, jstring fileName)
{
  //XXX: TODO
  return 0;
}

