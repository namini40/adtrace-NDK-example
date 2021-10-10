#include <jni.h>
#include <string>

extern "C" {
 JNIEXPORT jstring
JNICALL
Java_io_adtrace_ndkexample_MainActivity_getAppToken(
        JNIEnv *env,
        jobject thiz) {

    std::string token = "x1y2z3abc123";

    return env->NewStringUTF(token.c_str());
}
JNIEXPORT jlongArray JNICALL Java_io_adtrace_ndkexample_MainActivity_getSignatures(
        JNIEnv *env,
        jobject thiz) {

    jlong sign1 = 123456789;
    jlong sign2 = 987654321;
    jlong sign3 = 123456789;
    jlong sign4 = 987654321;
    jlong id = 1;

    jlongArray res ;
    res=env -> NewLongArray(5);

    jlong fill[5];
    fill[0] = id;
    fill[1] = sign1;
    fill[2] = sign2;
    fill[3] = sign3;
    fill[4] = sign4;

    (*env).SetLongArrayRegion(res,0,5,fill);
    return res;

 }

}




