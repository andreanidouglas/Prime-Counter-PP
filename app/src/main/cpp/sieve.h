#pragma  once
#include <inttypes.h>

typedef struct {
    long long number;
    uint8_t flag;
} value;

int sieve (uint64_t limit);