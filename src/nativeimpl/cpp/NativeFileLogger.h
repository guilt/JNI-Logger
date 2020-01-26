#ifndef NATIVE_FILE_LOGGER_H
#define NATIVE_FILE_LOGGER_H

#include <sys/stat.h>
#include <sys/types.h>

#ifdef _WIN32
#include <io.h>
#include <fcntl.h>

#define open(fileName, fileFlags) _open(fileName, fileFlags, _S_IREAD | _S_IWRITE)
#define close(fileHandle) _close(fileHandle)
#define openFlags _O_APPEND | _O_CREAT | _O_BINARY | _O_WRONLY | _O_ASYNC
#else

#define openFlags O_APPEND | O_CREAT | O_WRONLY

#endif

#endif /* NATIVE_FILE_LOGGER_H */