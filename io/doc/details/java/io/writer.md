# Writer API

该类是一个抽象类，用于将字符写入字符流。该类的子类必须实现的方法包括`write(char[], int, int), flush(), close()`。

**属性：**
1. `private char[] writeBuffer` 用于存放写入的字符或字符串的临时缓存。
2. `private static int WRITE_BUFFER_SIZE = 1024` `writeBuffer`的大小，必须大于 1。
3. `protected Object lock` 用于该流的同步操作。**不要使用流本身`this`作为锁对象**。

**方法：**
1. write(int): void
    * 该方法写入一个单独的字符。被写入的字符为整型参数的低18位，高18位将被忽略。
2. write(char[]): void
    * 该方法向输出流中写入一个**字符数组**。
3. write(char[], int off, int len): void
    * 该方法将字符数组的部分写入输出流中,`off`为写入的第一字符在字符数组中的下标,`len`为写入字符的数量。
4. write(String): void
    * 该方法向输出流中写入一个字符串。
5. write(String, int off, int len): void
    * 该方法向输出流中想写入字符串的一部分，`off`为写入字符的偏移量，`len`为写入的字符的长度。
    * 如果`off, len`中任意一个为负数，或者`off + len`大于指定字符串的长度，则抛出`IndexOutofBoundsException`。
    * 该方法实际上是将字符串转换为字符数组，然后将字符数组写入输出流中。
6. append(CharSequence cs): Writer
    * 该方法将指定的字符序列追加到`writer`对象中。它的作用与`append(css.toString())`一样。
    * 它依赖于字符序列`cs`的`toString()`方法，可能不会追加整个的字符序列。
    * 当参数`cs`为`null`时，四个字符*null*将被追加到`writer`对象中。
7. append(CharSequence cs, int start, int end): Writer
    * 该方法将指定字符序列的一个**子序列**追加到`writer`对象中。当参数`cs`不为`null`时，与`append(cs.subSequence(start, end).toString)等效。
    * 当`cs`为`null`时，它会被当做有四个字符*null*。
    * 当`start, end`任意一个为负数，或者`end < start`，或者`end > cs.length`时，会抛出`IndexOutOfBoundsException`。
8. append(char c): Writer
    * 该方法将指定的字符追加到`writer`对象中。它与`write(char)`等效。
    * 参数`c`为16bit的字符。
9. flush(): void
    * 该方法会刷新输出流。如果该对象存在任何缓存的字符，则会立即被写入到目的地。如果目的地也是一个字符或字节流，同样会`flush`。也就是说，一个`flush()`
        会刷新一条链上的所有`Writer, OutputStream`对象。
    * 如果目的地是操作系统提供的抽象，则不能保证数据被写入物理设备中。
10. close(): void
    * 该方法会关闭输出流，并立即`flush()`它。
    * 如果流已经被关闭，在调用`write(). flsuh()`则会抛出`IOException`。
    * 关闭已经被关闭的流不会由任何影响。