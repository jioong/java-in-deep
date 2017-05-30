# epoll

`epoll`是一个IO事件通知设备(event notification facility)。
`epoll` API实现与`poll`相同的任务：**监视多个文件描述符，查看在它们之上是否有可执行的IO操作。**
它有两种触发模式:`edge triggered`边界触发模式和`level triggered`水平触发模式。

有三个系统调用方法用于创建和管理epoll实例：
1. `epoll_create()`，创建一个epoll实例并返回一个引用该实例的文件描述符。
2. `epoll_ctl()`，注册感兴趣的文件描述符的事件。注册在该实例上的文件描述符集合被称为`epoll 集合`。
3. `epoll_wait`，等待IO事件，**如果当前没有可用的事件则阻塞当前线程。**


流程：
1. 创建一个epoll实例。
2. 向该实例注册非阻塞IO操作。
3. 查询准备好的IO操作集合。
4. 处理准备好IO操作的集合。

基于事件通知机制，每次调用wait()方法时，会返回准备好IO操作的集合。