# BufferedInputStream API

`BufferedInputStream`在其他输入流的基础上添加了以下额外的功能，它拥有缓存输入流的能力并支持`mark(), reset()`方法。
当创建一个`BufferedInputStream`对象时，内部会创建一个**缓存数组**。当读取或跳过字节，当需要时它会从它包含的输入流中**一次读取多个**字节填满*refilled*内部缓存数组。

## 属性

1. `DEFAULT_BUFFER_SIZE = 8192` 
2. `MAX_BUFFER_SIZE = Integer.MAX_VALUE - 8` 允许分配的最大数组大小
3. `byte[] buf` 内部缓存数据，也就是存储数据的地方。当需要时，它会被一个其他大小的数组替换。
4. `count` 比缓存中最后一个有效索引大1，有效范围为`0 - buf.length`。
5. `pos` 缓存的当前位置，也就是下一个将从缓存数组`buf`中读取的字符的索引,其范围为`0 - count`。
    * 当它比`count`小时，,`buf[pos]`就是下一个将被消费的字节。
    * 当它等于`count`时，下一个`read(), skip()`将会从底层输入路由中读取字节(填充缓存数组)。
6. `markPos = -1` 即上一次调用`mark()`时的`pos`值,它的范围为`-1 - pos`。
    * 当输入流没有调用`mark()`时，该值为 -1 。
    * 当输入流上调用过`mark()`时，`buf[markPos]`是下一次调用`reset()`后第一个将被消费的元素。
    * 如果`markPos != -1`，则`buf[markPos] - buf[pos - 1]`之间的元素必须保存在`buf`数组中。它们可能会被移到另外一个数组中,并调整`count, pos, markPos`的值.
        它们不会丢弃，除非`pos - markPos`的差值大于`marklimit`。
7. `marklimit` 当`pos - markPos > marklimit`时，设置的标记会被丢弃并且`markPos` 会被设置为 -1。

## 构造器

1. `BufferedInputStream(InputStream in)`
    * 该构造器使用默认缓存大小作为缓存数组的大小。
2. `BufferedInputStream(InputStream in, int size)`
    * 参数`size`指定缓存数组的大小。
    
## 方法

1. synchronized read(): void
    * 该方法是一个同步方法。它会从缓存数组中读取字符，当`pos >= count`时，也就是，读取到缓存数组的最后一位后调用`fill()`方法填充缓存数组。
    * 调用`fill()`方法后，如果`pos >= count`，说明已经读到输入流的末尾，返回 -1。
2. synchronized read(byte[] b, int off, int len): void
    * 该方法从字节输入流中读取字符，并写入数组`b`中，开始索引位置为`off`