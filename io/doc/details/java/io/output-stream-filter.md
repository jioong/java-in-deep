# FilterOutputStream API

该类是所有用于过滤输出流的类的超类。该流是基于一个已经存在的流作为它的数据的宿，并可以添加额外的功能。
`FilterOutputStream`只是简单的覆写了所有`OutputStream`中的方法。

## 属性

1. `OutputStream out` 将被过滤的底层输出流。

## 构造器

1. FilterOutputStream(OutputStream out)
    * 该构造器用指定的输出流构造一个输出流过滤器。
    
## 方法

1. write(int b): void
    * 该方法将指定的`byte`写入输出流中，它只是简单的调用底层输出流的`write()`方法。
2. write(byte[] b): void
    * 该方法将数组`b`中的`b.length`个字节写入输出流中。
    * 注意，该方法不是调用底层输出流中只有一个参数的`write`方法。
3. write(byte[] b, int off, int len): void
    * 该方法从指定数组中写`len`个字节到输出流中，起始索引为`off`。
4. flush(): void
    * 该方法刷新输出流，并强制将所有缓冲的数据刷新到输出流中。
5. close(): void
    * 该方法会关闭输出流，并释放与该流关联的系统资源。
    * 该方法会先调用`flush()`，再调用底层流的`close()`。