# InputStreamFilter API

一个`InputStreamFilter`对象包含其他一些输入流，被当做它的基础数据源，可以提供一些额外的功能。`InputStreamFilter`只是简单的覆写了`InputStream`
的所有方法

## 属性

1. `InputStream in` 将被过滤的输入流。

## 方法

1. read(): int
    * 该方法从输入流中读取下一个字节*byte*,返回值为整型,范围为 0 - 255。如果因为到达输入流的末尾而不能读取数据，则返回 -1.
    * 该方法将会被阻塞，直到1)数据可用，2)到达输入流的末尾，3)抛出异常。
2. read(byte[] b): int
    * 该方法从输入流中读取`b.length`个字节并写入数组中`b`中，只是简单的调用`in.read(b, 0, b.length)`。返回值为实际读取的字节数，或 -1。
    * 该方法也会阻塞，直到数据可用。
3. read(byte[] b, int off, int len): int
    * 该方法最多读取`len`个字节写入数组`b`中，写入的起始索引为`off`。
    * 当`len != 0`时，该方法会阻塞直到数据可用。或者，没有数据可读时，返回 0。
    * 当参数`b == null`时，抛出`NullPointerException`。
    * 当`off, len`中任意一个为负数，或者`len > b.length - off`时，抛出`IndexOutOfBoundsException`。
4. skip(long n): long
    * 该方法会从输入流中跳过并丢弃`n`个字节。其返回值为实际跳过的字节数。
    * 该方法可能因为各种原因导致实际跳过的字节数小于`n`,也可能为0。
    * 当该输入流不支持`seek`，或者发生其他`IO`错误时，抛出`IOException`。
5. available(): int
    * 该方法会返回在该输入流上下一次调用`read(), skip()`且不会被阻塞的预估字节数。
    * 下一个方法调用可以是同一个线程，也可以是其他线程。`read(), skip()`该方法返回的字节数时，方法不会阻塞。
6. close(): void
    * 该方法关闭输入流，并释放管理的系统资源。
7. synchronized mark(int readlimit): void
    * 该方法在输入流的当前位置设置标记位,当下一次调用`reset`时,输入流会重定位到上一个`mark`调用时流所在的位置，以便可以`re-read`同样的字节。
    * 参数`readlimit`指明在标记失效前，可以再读取的最大字节数。
8. synchronized reset(): void
    * 该方法会重定位到上一次`mark()`调用时所在的位置。
    * 设置标记的使用场景一般为，想要看一下输入流的前面一些是什么内容。
9. markSupported(): boolean
    * 该方法用于判断输入流是否支持`mark(), reset()`方法。