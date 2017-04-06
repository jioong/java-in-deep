# Class API

一个`Class`的实体代表一个在正在运行的Java程序中的**一个类或接口**。
一个**枚举**是一种特殊类型的**类**,一个**注解**是一种特殊的**接口**。数组也属于是**类**的一种，原生Java类型`boolean, byte, char, short, int, long
, float, double`和关键字`void`同样能用一个`Class`对象表示。

`Class`类没有共有的构造器，`class`对象再被加载时由JVM自动构造。


## 方法

1. forName(className): Class<?>
    * 该方法返回与该名字关联的类或接口的`Class`对象，它与`Class.forName(className, true, currentLoader)`等价。
    * `currentLoader`指的是加载当前文件的类类加载器。
    * 调用该方法会导致指定的类被初始化。
    * `className`是要加载类的全限定名。
2. forName(String className, boolean initialize, ClassLoader loader): Class<?>
    