//
// Created by cmte on 8/4/21.
//
#include "sieve.h"


#include <stdlib.h>
#define UNDEFINED 0
#define NON_PRIME 1
#define PRIME 2



int sieve (uint64_t limit){

    value *v;
    long long i;
    v = (value *) malloc(sizeof(value) * limit);
    if (v == NULL) {
        return -1;
    }

    for (i = 2; i < limit - 2; ++i) {
        v[i].number = i;
        v[i].flag = UNDEFINED;
    }

    for (i = 2; i < limit - 2; ++i){
        if (v[i].flag == NON_PRIME) continue;

        v[i].flag = PRIME;
        long long z = i;
        long long j = z * z;

        while (j < limit) {
            v[j].flag = NON_PRIME;
            j = v[i].number * z;
            z++;
        }
    }
    int count = 0;
    for (i = 2; i < limit - 2; ++i) {
        if (v[i].flag == PRIME) {
            count ++;
        }
    }

    free(v);
    return count;

}
