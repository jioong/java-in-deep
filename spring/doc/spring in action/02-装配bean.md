# 装配Bean

任何一个成功的用于都是由多个为了实现某一个业务目标而相互协作的组件构成的。这些组件必须彼此了解，并且相互协作来完成工作。
创建应用对象之间的协作关系的行为称为**装配　Ｗiring**，这也是依赖注入的本质。

Ｓpring提供了三种主要的装配机制：
* 在XML文件中进行显示配置。
* 在Java中进行显示配置**JavaConfig**。
* 隐式的`bean`发现机制和自动装配。

> 显示的配置越少越好。JavaConfig配置是类型安全的。

## 1. 自动化装配Bean

Spring从两个角度来实现自动化装配：
* 组件扫描(component scanning)，Spring会自动发现应用上下文中所创建的`bean`。
* 自动装配(autowiring),Spring自动满足`bean`之间的依赖

组件扫描**默认是不启用的**，需要显示配置以下Spring，从而命令它去寻找带有`@Component`注解的类，并为其创建`bean`。

### 1.1 为组件扫描的bean命名

Spring应用上下文中所有的`bean`都会给定一个`ID`。当没有明确设置该`ID`时，Spring会根据类名为期指定一个`ID`。具体来说，也就该`ID`为将类名的第一个字母变为小写。
如果想要为`bean`设置不同的`ID`,所要做的就是将期望的`ID`作为值传递给`@Component`注解。
另外一种为`bean`命名的方式，是使用Java依赖规范中所提供的`@Named`注解来设置`bean`的`ID`。

### 1.2 设置组件扫描的基础包

当没有为`@ComponentScan`注解设置任何属性时，它会以配置类所在的包作为基础包`base package`来扫描组件。

* 如果想要扫描不同的包呢?
* 如果想要扫描多个基础包呢?

设置基础包的一个好处在于，**可以将配置类放在单独的包中，与其他应用代码区分开来。**
`@ComponentScan`注解的`basePackages`属性可以传入多个基础包。该中配置的一点不好之处在于，它是类型不安全的。
该注解还提供另一种方法，即指定包中所包含的类或接口`basePackageClasses`属性。

### 1.3 通过为bean添加注解实现自动装配

自动装配就是让`spring`自动满足`bean`依赖的一种方法。在满足依赖的过程中，会在`spring`应用上下文中寻找匹配某个`bean`需要的其他`bean`。
为了声明要进行自动装配，可以借助`@Autowired`注解。

> 在Spring初始化bean之后，它会尽可能地去满足bean的依赖。

如果没有匹配的`bean`，那么在创建应用上下文的时候，Spring会抛出一个异常。

## 2. 通过Java代码装配bean

尽管在很多场景下可以通过组件扫描和自动装配实现Spring的自动化配置，但如果自动化配置行不通，则需要明确配置Spring。如
* 需要将第三方库中的组件装配到应用中时，这种情况下必须使用显示装配的方式。

> 通常将JavaConfig放在单独的包中，使其与其他的应用程序逻辑分离开来。

### 2.1 创建配置类

创建`JavaConfig`类的关键在于为其添加`@Configuration`注解，该注解表明这个**类**是一个配置类，该类应该包含在Spring应用上下文中如何创建`bean`的细节。

### 2.2 声明简单的bean

要在`JavaConfig`中声明`bean`，需要编写一个方法，**该方法会创建所需类型实例**，然后给该方法添加`@Bean`注解。

### 2.3 借助JavaConfig实现注入

在`JavaConfig`中装配`bean`的最简单的方式就是引用创建`bean`的方法。

## 3. 通过XML装配bean

### 3.1 创建XML配置规范

在XML配置中，要以`<beans>`元素为根。如
```XML
<?xml version="1.0" encoding="ISO-8859-1"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">
       
       <!-- configuration details go here -->
</beans>
```

借助*Spring Tool Suite*创建XML配置文件。

### 3.2 借助构造器注入初始化bean

在XML中声明DI时，针对构造器注入由两种基本的配置方法可供选择：
* `<constructor-arg>`元素
* 使用`Spring 3.0`时引入的*c-命名空间*