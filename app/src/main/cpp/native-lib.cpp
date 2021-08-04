#include <jni.h>
#include <string>
#include "sieve.h"

extern "C" JNIEXPORT jint JNICALL
Java_andredr_com_PrimeCounterPP_MainActivity_sieve(JNIEnv* env, jobject, jlong limit) {

    return sieve((uint64_t) limit);
}

