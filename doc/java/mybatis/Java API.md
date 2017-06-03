# Java API

## SqlSessions

主要的Java接口就是`SqlSession`，它的实例是由`SqlSessionFactory`实例创建的，`SqlSessionFactory`对象包含了创建`SqlSession`实例的所有方法。
而`SqlSessionFactory`是由`SqlSessionFactoryBuilder`创建的，它可以从XML配置、注解或手动配置Java来创建`SqlSessionFactory`。

**注意：**当MyBatis与一些依赖注入框架一起使用时(Spring, Guice),`SqlSession`将被依赖注入框架所创建。

MyBatis将会按照如下顺序查找属性：
1. 在properties元素体中指定的属性首先被读取。
2. 在properties元素的类路径resource或url指定的属性第二个被读取，可以覆盖已经指定的重复属性。
3. 作为方法参数传递的属性最后被读取，可以覆盖之前的属性。