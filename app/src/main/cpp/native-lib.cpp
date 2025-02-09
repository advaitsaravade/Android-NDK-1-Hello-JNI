#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_me_advaitsaravade_hellojni_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Kotlin says, Hello there!";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jstring JNICALL
Java_me_advaitsaravade_hellojni_MainActivity_returnStringFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jstring inputStr) {
    const char *inputCStr = env->GetStringUTFChars(inputStr, nullptr);
    std::string result = "Grievous says, " + std::string(inputCStr);
    env->ReleaseStringUTFChars(inputStr, inputCStr);
    return env->NewStringUTF(result.c_str());
}

extern "C" JNIEXPORT jint JNICALL
Java_me_advaitsaravade_hellojni_MainActivity_additionFromJNI(
        JNIEnv *env,
        jobject /* this */,
        jint first,
        jint second
) {
    return first + second;
}