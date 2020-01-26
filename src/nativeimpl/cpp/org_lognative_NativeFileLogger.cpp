#include "NativeFileLogger.h"

#include "jni.h"
#include "org_lognative_NativeFileLogger.h"

static const char *strLogSeparator = {"\n"};
static const int strLogSeparatorLength = 1*sizeof(char);

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_logToFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle, jstring givenString)
{
  const char *rawString = jniEnvironment->GetStringUTFChars(givenString, JNI_FALSE);
  int lengthOfRawString = jniEnvironment->GetStringUTFLength(givenString);
  write(fileHandle, rawString, lengthOfRawString*sizeof(char));
  write(fileHandle, strLogSeparator, strLogSeparatorLength);
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_logBytesToFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle, jbyteArray givenBytes, jint offset, jint length)
{
  const jbyte* rawBytes = jniEnvironment->GetByteArrayElements(givenBytes, JNI_FALSE);
  write(fileHandle, rawBytes+offset, length*sizeof(jbyte));
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_flushFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle)
{
  //XXX: TODO
}

JNIEXPORT void JNICALL Java_org_lognative_NativeFileLogger_closeFile(JNIEnv *jniEnvironment, jobject thisObject, jint fileHandle)
{
  close(fileHandle);
}

JNIEXPORT jint JNICALL Java_org_lognative_NativeFileLogger_openFile(JNIEnv *jniEnvironment, jobject thisObject, jstring fileName)
{
  const char *rawFileName = jniEnvironment->GetStringUTFChars(fileName, JNI_FALSE);
  jint fileHandle = (jint) open(rawFileName, openFlags);
  return fileHandle;
}

