# IO 流
  
在`Java API`中，可以从其中**读入一个字节序列**的对象称作**输入流**,而可以向其中**写入一个字节序列**的对象称作**输出流**。这些字节序列的来源可以是：
* 文件
* 网络连接
* 内存
* ...

**抽象类`InputStream, OutputStream` 构成了输入/输出类层次结构的基础。**
但是，因为面向字节的流不便于处理以`Unicode`形式储存的信息，所以从抽象类`Reader, Writer`中继承出一个专门用于处理`Unicode`字符的单独的类层次结构。
这些类拥有的读入和写出操作**都是基于两字节的Unicode码元的，而不是基于单字节的字符。**
**所有在java.io中的类都将相对路径名解释为以用户工作目录开始，`System.getProperty("user.dir)`可以获得。**

1. [java.io.InputStream](./details/java/io/input-stream.md)  
2. [java.io.OutputStream](./details/java/io/output-stream.md)  
这两个类中的`read(), write`方法在执行时都将**阻塞**，直至字节确实被读入或写出，这就意味着如果流不能被立即访问，那么**当前的线程将被阻塞**。这使得
在这两个方法等待指定的流变为可用的这段时间里，**其他的线程**就有机会去执行有用的工作。
3. [java.io.Reader](./details/java/io/reader.md)
4. [java.io.Writer](./details/java/io/writer.md)

`FileInputStream, FileOutputStream`可以提供附着在一个磁盘文件上的输入流和输出流，只需要向其构造器提供文件名或文件的完整路径名。这两个类与
`InputStream, OutputStream`一样，只支持**字节级别**上的读写。它们用于向原声字节流**添加额外的功能**。

> 关于流，Java使用机制来分离职责。某些流可以从文件和其他更外部的位置上获取字节，而其他流可以将字节组装成更有用的数据类型。Java程序员必须对二者进行组合。

5. FileInputStream
6. FileOutputStream
7. InputStreamReader
8. OutputStreamWriter

