# FileOutputStream API

文件输出流用于将数据写入`File`或者`FileDescriptor`中，不管这个文件是已经存在还是会被创建。
有些平台，会限制在同一时刻只有一个`FileInputStream`能打开一个文件去写数据。这种情况下，该类的构造器就会失败，当调用的文件已经被打开。

> `FileDescriptor`对象是用于表示文件连接。

## 属性

1. `FileDescriptor fd` 基于系统的文件描述符
2. `boolean append` 当为`true`时为追加模式
3. `FileChannel channel`关联的管道，会被延迟初始化。
4. `String path` 引用文件的路径，当该文件输出流是用文件描述符创建时为`null`
5. `Object closeLock = new Object()`
6. `boolean closed = false`

## 构造器

1. FileOutputStream(String name)
    * 基于指定的文件名创建一个文件输出流,同时会创建一个表示与文件连接的`FileDescriptor`对象。
    * 如果存在安全管理，则会首先执行`checkWrite`方法,以`name`为参数。
    * 如果1)文件存在但是是一个文件夹，2)文件不存在且不能被创建，3)文件不能被打开,则会抛出`FileNotFoundException`。
2. FileOutputStream(String name, boolean append)
    * 当第二个参数为`true`时，字节会被写到文件的末尾而不是开头。
3. FileOutputStream(File file)
    * 通过指定的`File`对象创建一个文件输出流。
4. FileOutputStream(File file, boolean append)
5. FileOutputStream(FileDescriptor fdObj)
    * 用一个文件描述符创建一个文件输出流，文件描述符表示一个已存在的与实际文件的连接。
    * 如果参数`fdObj`为`null`，则会抛出`NullPointerException`
    
## 方法

1. write(int b): void
    * 该方法向文件输出流中写入指定的字节。
2. write(byte[] b, int off, int len): void
    * 该方法向文件输出流中写入指定数组中的一个子数组。
3. write(byte[] b)
    * 该方法向文件输出流中写入字节数组。
4. close(): void
    * 该方法关闭文件输出流并释放关联的系统资源。之后，该流不能用于写入字节数据。
    * 如果该流有关联的管道，则`channel`也会被关闭。
5. getFD(): FileDescriptor
    * 该方法返回与该流关联的文件描述符。
6. getChannel(): FileChannel
    * 该方法返回与文件输出流关联的管道。
    * 该管道的初始`position`与流中已写入的字节数相等。当为追加`append`模式时，则与文件中的字节数相等。
    * 当向文件输出流中写数据时，同样的会增加管道的`position`。改变管道的位置，也会改变输出文件流的位置。