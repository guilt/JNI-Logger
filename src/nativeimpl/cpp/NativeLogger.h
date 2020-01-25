#ifndef NATIVELOGGER_H
#define NATIVELOGGER_H

#include <string.h>
#include <stdio.h>

#define sanePutc(c) if (c != '\r') putchar(c)
#define sanePuts(givenString) puts(givenString)

#endif /* NATIVELOGGER_H */