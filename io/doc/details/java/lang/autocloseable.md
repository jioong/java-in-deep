# AutoCloseable API

一个对象可能会持有资源，如文件或套接字句柄，直到被关闭。`AutoCloseable`对象的`close()`方法会在离开`try-with-resource`代码块时自动调用,这种结构会保证
及时释放资源，