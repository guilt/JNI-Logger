#ifndef NATIVE_FILE_LOGGER_H
#define NATIVE_FILE_LOGGER_H

#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>

#ifdef _WIN32

#include <io.h>

#define openImpl(fileName, fileFlags, modeFlags) _open(fileName, fileFlags, modeFlags)
#define closeImpl(fileHandle) _close(fileHandle)
#define flushImpl(fileHandle)
#define openFlags _O_APPEND | _O_CREAT | _O_WRONLY | _O_ASYNC | _O_BINARY
#define permFlags _S_IREAD | _S_IWRITE

#else

#include <unistd.h>

#define openImpl(fileName, fileFlags, modeFlags) open(fileName, fileFlags, modeFlags)
#define closeImpl(fileHandle) close(fileHandle)
#define flushImpl(fileHandle) fsync(fileHandle)
#define openFlags O_APPEND | O_CREAT | O_WRONLY | O_ASYNC
#define permFlags S_IRUSR | S_IWUSR

#endif

#endif /* NATIVE_FILE_LOGGER_H */
