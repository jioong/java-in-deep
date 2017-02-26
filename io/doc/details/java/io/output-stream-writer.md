# OutputStreamWriter API

`OutputStreaWriter`是将字符流转换为字节流的桥梁，字符会使用指定的`Charset`编码成字符。字符集可能通过名字，或`Charset`对象，或平台的默认字符集。
每次调用`write()`方法都是用指定的字符集将字符编码成字节,结果字符将暂时存储在缓存中然后被写到底层输出流中。该缓存的大小可以指定，但是默认的大小一般够使用。
注意，传递给`write()`方法的字符参数没有被缓存。
为了提高效率，可以使用`BufferedWriter`包装`OutputStreamWriter`对象。

## 属性

1. `StreamEncoder se`

## 构造器

1. OutputStreamWriter(OutputStream out, String charsetName)
    * 该构造器通过指定字符集的名字来构造对象。
    * 其参数`charset`为支持的字符集的名字，如果不支持该字符集则抛出`UnsupportedEncodingException`。
2. OutputStreamWriter(OutputStream out)
    * 该构造器使用默认的字符集编码。
3. OutputStreamWriter(OutputStream out, Charset cs)
    * 该构造器使用指定的字符集对象构造。
4. OutputStream(OutputStream out, CharsetEncoder ce)
    * 该构造器使用指定的字符集编码器对象。

## 方法

1. getEncoding(): String
    * 该方法返回该流的字符集编码的名字。
    * 当该流已经被关闭时，返回`null`。
2. flushBuffer(): void
    * 该方法将缓冲区中的数据刷新到底层字符流中，而不会刷新字符流本身。
    * 该方法不是私有方法,是**默认级别的访问权限**，只是为了让`PrintStream`调用。
3. write(int): void
    * 该方法向输出流中写入单个字符。
4. write(char[], int off, int len)
    * 该方法将字符数组中的部分写入到输出流中。
5. write(String ,int off, int len)
    * 该方法将子字符串写入输出流中。
6. flush(): void
    * 该方法刷新输出流。
7. close(): void