# AutoCloseable API

一个对象可能会持有资源，如文件或套接字句柄，直到被关闭。`AutoCloseable`对象的`close()`方法会在离开`try-with-resource`代码块时自动调用,这种结构会保证
及时释放资源，可以避免资源耗尽异常或其他错误。

如果可能的话，在基类中实现该接口，即使不是它的所有子类和实例都会持有资源。**推荐使用`try-with-resource`结构**.

当使用`Stream`这种同时支持`IO, non-IO`的工具，如果使用`non-IO`格式时不需要使用`try-with-resource`块。


## 方法

1. close(): void
    * 该方法会关闭资源，并释放底层资源。该方法在`try-with-resource`块管理的对象中会自动调用。
    * 该接口抛出`Exception`，但是其实现类应该抛出更具体的异常，或者在操作不允许失败的情况下不抛出异常。
    * 强烈建议，应该在抛出异常之前，先释放底层资源,并将资源标记为`close`。