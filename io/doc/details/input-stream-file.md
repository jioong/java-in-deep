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
    