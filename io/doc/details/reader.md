**Reader API**

该抽象类用于读取**字符流**,该类的子类必须实现的方法是`read(char[], int, int), close()`。

**属性:**  
1. `protected Object lock` 该对象用于该流的同步操作。从性能的角度来讲，一个字符流对象应该使用一个`object`而不是它本身来保护**临界资源 critical sections**。
    该类的子类应该使用该域中的对象而不是它本身`this`或同步方法。  
2. `maxSkipBufferSize = 8192` 跳过缓存的最大数。
3. `char[] skipBuffer`


**方法:**  
1. read(CharBuffer target): int
    * 该方法尝试向`targer`写入字符,当`target`为只读缓存时，抛出`ReadOnlyBufferException`。  
2. read(): int
    * 该方法只读入一个字符。返回值范围在`0 - 65535`,当到达输入流的末尾时返回 -1。
    * 该方法会被阻塞，直到1)一个字符可用，2)出现IO错误,3)到达流的末尾。  
3. read(char[]): int
    * 该方法向一个数组中写入字符。返回值为读取的字符数，当到达输入流的末尾时返回 -1。
    * 该方法也会被阻塞。
4. read(char[], int off, int len): int
    * 该方法将字符读入字符数组的一部分。
    * 该方法也会被阻塞。
5. skip(long): long
    * 该方法会跳过输入流中指定数量的字符，返回值为实际跳过的字符的数量。
    * 该方法也会被阻塞。
    * 被跳过的字符会被存储在`skipBuffer`中。
6. ready(): boolean
    * 该方法用于判断流是否已准备好被`read`。
    * 当能保证下一个`read()`不会被阻塞时，返回`true`。否则，返回`false`。
    * 注意，返回`false`时不保证下一个`read()`会被阻塞。  
7. markSupported(): boolean
    * 该方法用于判断流是否支持`mark()`操作。
    * 该方法的默认实现总是返回`false`，子类应该覆盖该方法。
8. mark(int readAheadLimit): void
    * 在当前位置设置标志位，当调用`reset`方法时,会尝试重新定位到该位置。
    * 不是所有的字符输入流都支持该操作。
    * 当`mark()`之后读取的字符数操作`readAheadLimit`时，`reset`操作会失败。
9. reset(): void
    * 该方法会重置输入流。
    * 如果该流设置过标识位，则尝试回到该标志位时的状态。
    * 如果该流没有设置过标识位，则会尝试重置到与特定流相关的状态。
    * 不是所有的字符输入流都支持`reset`操作，有些流支持`reset`操作而不支持`mark()`操作。
10. close(): void
    * 该方法会关闭输入流，并释放与该流相关的所有系统资源。
    * 当一个流被关闭后，在调用其他方法会抛出`IOException`。
    * 关闭一个之前已经被关闭的流不会由任何作用。