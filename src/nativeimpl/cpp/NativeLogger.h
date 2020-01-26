#ifndef NATIVE_LOGGER_H
#define NATIVE_LOGGER_H

#include <stdio.h>

#define sanePutc(c) if (c != '\r') putchar(c)
#define sanePuts(givenString) puts(givenString)

#endif /* NATIVE_LOGGER_H */