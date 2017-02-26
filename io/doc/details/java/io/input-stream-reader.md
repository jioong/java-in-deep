# InputStreamReader API

`InputStreamReader`是从字节流通往字符流的桥梁,它们读入字节并通过指定`Charset`编码成字符。
每次调用`InputStreamReader.read()`方法时，都会从底层的流中读取一个或多个字节。为了提高将字节转换为字符的效率，会从底层流中读取多余当前`read`操作
所需要的字节数。**为了提高效率，可以用`BufferedReader`包装`InputStreamReader`。**

## 属性

1. `StreamDecoder sd` 

## 构造方法

1. InputStreamReader(InputStream in)
    * 该构造器用默认的字符集创建一个`InputStreamReader`对象。
2. InputStreamReader(InputStream in, String charsetName)
    * 该构造器使用指定的字符集。
    * 其中参数`charsetName`为支持的`Charset`名。如果不支持指定的字符集，则会抛出`UnsupportedEncodingException`.
3. InputStreamReader(InputStream in, Charset cs)
    * 该构造器使用指定的`Charset`对象。当`cs`为`null`时，会抛出`NullPointerException`。
4. InputStreamReader(InputStream in, CharsetDecoder cd)
    * 该构造器使用指定的字符集解码器。
    
## 方法

1. getEncoding(): String
    * 该方法返回该流使用的字符集编码格式的名字。
    * 如果该流使用`InputStreamReader(InoutStream, String)`构造，那么可能返回的名字与构造时传入的不一样。
    * 当该流已经被关闭时，该方法会返回`null`。
2. read(): int
    * 该方法会读取单个字符。其返回值为读取的字符的整型值，当到达输入流的末尾时，返回 -1。
3. read(char[], int off, int len)
    * 该方法会向字符数组的部分元素中写入字符。其返回其为向数组中写入的字节数，或 -1。
    * 参数`off`为数据中开始存放数据的元素的索引。
    * 参数`len`为最多 可能会读取的字符数。
4. ready(): boolean
    * 该方法用于去判断流是否已经准备好被读取`read`。
    * 一个`InputStreamReader`处于`ready`状态，当1)它的输入缓存不为空，2)底层的字节流已经准备好字节被读取。
5. close(): void