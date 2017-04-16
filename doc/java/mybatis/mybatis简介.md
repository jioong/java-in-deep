# MyBatis 简介

## 什么是MyBatis？

MyBatis是支持1)定制化SQL，2)存储过程，3)高级映射的优秀的**持久层框架**。MyBatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集。

MyBatis可以对配置和原生Map使用简单的XML或注解，将接口和Java的`POJOs`映射成数据库中的记录。

## 入门

当使用Maven来构建项目时，需要添加依赖：
```
<dependency>
  <groupId>org.mybatis</groupId>
  <artifactId>mybatis</artifactId>
  <version>x.x.x</version>
</dependency>
```

### 从XML中构建SqlSessionFactory

> 每个基于MyBatis的应用都是以一个SqlSessionFactory实例为中心的。  

该实例可以通过`SqlSessionFactoryBuilder`来获得。而`SqlSessionFactoryBuilder`可以从XML配置文件或一个预先定制的`Configuration`实例构建出
`SqlSessionFactory`的实例。

MyBatis包含一个`Resources`的工具类，可以使用任意的输入流实例，包括字符串形式的文件路径或者URL形式的文件路径来配置。**建议使用类路径下的资源文件进行配置。**

XML配置文件包含了对MyBatis系统的核心设置，包含获取数据库连接实例的数据源(DataSource)和决定事务作用域和控制方式的事务管理器(TransactionManager)。

### 不使用XML构建SqlSessionFactory

可以之间使用Java创建配置，如
```java
DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
TransactionFactory transactionFactory = new JdbcTransactionFactory();
Environment environment = new Environment("development", transactionFactory, dataSource);
Configuration configuration = new Configuration(environment);
configuration.addMapper(BlogMapper.class);
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
```

映射器类是Java类，它包含了SQL映射语句的注解从而避免了XML文件的依赖。

### 从SqlSessionFactory中获取SqlSession

SqlSession完全包含了面向数据库执行SQL命令所需的方法。可以通过SqlSession实例直接执行已映射的SQL语句。如
```java
SqlSession session = sqlSessionFactory.openSession();
try {
  Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
} finally {
  session.close();
}
```
  
另一种相对更优的方式：
```java
SqlSession session = sqlSessionFactory.openSession();
try {
  BlogMapper mapper = session.getMapper(BlogMapper.class);
  Blog blog = mapper.selectBlog(101);
} finally {
  session.close();
}
```

### 探究已映射的SQL语句

对命名空间的命名解析：
* 完全限定名，将被直接查找并且找到即用。
* 短名称，如果全局唯一可以作为一个单独的引用。如果不唯一，那么使用时就会收到错误报告。

**映射语句**可以不需要XML来做，取而代之的是使用**Java注解**。如
```java
public interface BlogMapper {
  @Select("SELECT * FROM blog WHERE id = #{id}")
  Blog selectBlog(int id);
}
```

这种方式的缺点在于，对于稍微复杂的语句就会显得很混乱。如果需要做复杂的事情，最好还是使用XML配置文件。

### 作用域和生命周期

**SqlSessionFactoryBuilder**
这个类可以被实例化、使用和丢弃，一旦创建了`SqlSessionFactory`它就不再被需要了。因此它的最佳作用域是方法作用域，也就是局部方法变量。可以重用它来创建多个`SqlSessionFactory`实例，
但是最好不要让它一直存在以保证所有的XML解析资源开放给更重要的事情。

**SqlSessionFactory**
一旦被创建就应该在应用的运行期间一直存在，没有任何理由对它进行清除或重建。使用`SqlSessionFactory`的最佳实践是在应用运行期间不要重复创建多次，多次重建
`SqlSessionFactory`会被认为是一种坏味道。**最佳作用域是应用作用域，最简单的就是使用单例。**

**SqlSession**
每个线程都应该有它自己的`SqlSession`实例。它不是线程安全的，因此不能被共享，所以它的最佳作用域是**请求或方法作用域**。绝对不能将一个`SqlSession`实例的引用
放在一个静态域，甚至一个类的实例变量也不行。

### 映射器实例(Mapper Instance)

映射器是创建用来绑定映射语句的接口。映射器接口的实例从SqlSession实例中获取。映射器实例的最佳作用域是方法作用域。
并不需要显示地关闭映射器实例。