#include "jni.h"
#include "NativeLogger.h"
#include "org_lognative_NativeLogger.h"

JNIEXPORT void JNICALL Java_org_lognative_NativeLogger_log(JNIEnv *jniEnvironment, jobject thisObject, jstring givenString)
{
  const char *rawString = jniEnvironment->GetStringUTFChars(givenString, JNI_FALSE);
  sanePuts(rawString);
}

JNIEXPORT void JNICALL Java_org_lognative_NativeLogger_logBytes(JNIEnv *jniEnvironment, jobject thisObject, jbyteArray givenBytes, jint offset, jint length)
{
  jbyte* rawBytes = jniEnvironment->GetByteArrayElements(givenBytes, JNI_FALSE);
  int i = offset;
  for(; i < length; ++i) {
      sanePutc(rawBytes[i]);
  }
}

JNIEXPORT void JNICALL Java_org_lognative_NativeLogger_flush(JNIEnv *jniEnvironment, jobject thisObject)
{
  fflush(stdout);
}
