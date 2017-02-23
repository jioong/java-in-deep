# FileInputStream API

该对象包含从文件系统的文件中读入的输入字节,它主要用于读取*raw bytes*原始字节，比如图片。

## 属性

1. `private final FileDescriptor fd` 文件描述符，用于操作打开的文件。
2. `private final String path` 引用文件的路径，当该流是通过一个文件描述符创建时，该属性为`null`。
3. `private FileChannel channel = null` 
4. `private final Object closeLock = new Object()`
5. `private volatile boolean closed = false`

## 构造函数

1. FileInputStream(String name)
    * 通过打开一个实际与文件的连接创建一个`FileInputStream`对象。同时，一个新的`FileDescriptor`对象被创建用于表示与文件的连接*connection*。
    * 如果存在安全管理*security manager*,它的`checkRead`会被调用，参数为`name`。
    * 如果1)指定的文件不存在，2)是一个文件夹而不是一个常规的文件，3)因为其他原因不能被打开,则会抛出`FileNotFoundException`。
    * 如果安全管理存在，并且它的`checkRead`拒绝文件的访问权，则会抛出`SecurityException`。
2. FileInputStream(File file)
    * 该方法通过`File`对象打开与实际文件的连接。
3. FileInputStream(FileDescriptor fdObj)
    * 该方法的参数为一个`FileDescriptor`对象，`fdObj`表示一个已经存在的与实际文件的连接。
    
## 方法

1. read(): int
    * 该方法会从输入流中读取一个字节的数据，该方法会阻塞,如果输入还不可用。
    * 返回值为下一个字节数据，如果读到输入流的末尾则返回 -1 。
2. read(byte[]): int
    * 该方法从输入流中读取`b.length`的字节写入字节数组中,返回值为实际读入的字节数。
3. read(byte[] b, int off, int len): int
    * 当`len`不为 0 时，该方法会阻塞直到输入可用。否则，不会读取任何字节，并返回 0 。
4. native skip(long n): long
    * 该方法会跳过并丢弃输入流中的`n`个字节的数据。
    * 该方法可能因为一些原因，导致实际跳过的字节数小于`n`,也可能为0。
    * 如果`n`为负数，则会尝试**向后跳**,如果文件不支持在当前位置向后跳，则会抛出`IOException`。
    * 当向前跳时，返回值为正数。当向后跳时，返回值为负数。返回值为实际跳过的字节数。
    * 参数`n`可能会比文件中剩下的字节数大，这样不会产生异常，它跳过的字节可能包括文件`EOF`后的字节,这种情况下再去`read`
        会返回 -1。
5. native available(): int
    * 该方法的返回值为**预估**在输入流中可读或可跳过且不会阻塞该输入流上下一个方法调用时的字节数。
    * 当文件处于`EOF`时，返回值为 0。
    * 用`read(), skip()`返回值数的字节时，方法不会被阻塞。
6. close(): void
    * 如果该流上有关联`channel`，则`channel`也会被关闭。
7. getFD(): FileDescriptor
    * 该方法返回在该输入流中使用的表示与实际文件相关联的是`FileDescriptor`对象。
8. getChannel(): FileChannel
    * 该方法的返回值为与该文件输入流相关联的独一无二的`FileChannel`对象。
    * 该`FileChannel`的`positon`位置与文件输入流中已读过的字节数相等。从输入流中读取字节，会增加`channel`中的*position*。
    * 改变`channel`中的位置，也会改变输入流中的位置。