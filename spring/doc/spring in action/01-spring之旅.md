# Spring 之旅

Spring 是为了解决企业级应用开发的复杂性而创建的，使用Spring可以让简单的`JavaBean`实现之前只有`EJB`才能完成的事情。但是，`Spring`不仅仅局限于服务端
的开发，任何Java应用都能在简单性、可测试性和松耦合等方面从Spring收益。

*Spring*最根本的使命：**简化Java开发。**  

为了降低Java开发的复杂性，Spring采取了以下4种关键策略：
* 基于`POJO`的轻量级和最小侵入性编程。
* 通过依赖注入和面向接口实现松耦合。
* 基于切面和惯例进行声明式编程。
* 通过切面和模板减少样板式代码。

Spring的非侵入编程意味着这个类在Spring应用和非Spring应用中**都可以发挥同样的作用。**

## 依赖注入

按照传统做法：每个对象负责管理与自己相互协作的对象的引用，这将导致高度耦合和难以测试的代码。

耦合具有两面性：
1. 紧密耦合的代码难以测试、难以复用、难以理解。
2. 一定程度的耦合又是必须的，完全没有耦合的代码什么也做不了。

通过DI，对象的依赖关系将由系统中负责协调各对象的第三方组件在创建对象的时候进行设定。对象无需自行创建或管理它们的依赖关系。
依赖关系将被自动注入到需要它们的对象当中去。

如果一个对象只通过接口(而不是具体实现或初始化过程)来表明依赖关系，那么这种依赖就能够在对象本身毫不知情的情况下，**用不同的具体实现来进行替换。**

对依赖进行替换的一个最常用的方法就是在测试的时候使用`mock`实现。

依赖注入的方式：
1. 构造器注入(Constructor injection)

创建应用组件之间的协作行为通常称为**装配 Wiring**。Spring有多种装配方式：
1. 采用`XML`配置文件

> 只有Spring通过它的配置，能够了解这些组成部分是如何装配起来的。这样的话，可以在不改变所依赖的类的情况下，修改依赖关系。

Spring通过**应用上下文(Application Context)**装在`bean`的定义并把它们组装起来。Spring应用上下文全权负责对象的创建和组装。`Spring`自带多种应用上下文的实现，
它们之间的区别仅仅在于如何加载配置。

## 应用切面

DI能够让相互协作的软件组织保持松散耦合，而面向切面编程允许**将遍布应用各处的功能分离出来形成可重用的组件。**

面向切面编程往往被定义为**促使软件系统实现关注点分离**的一项技术。系统由许多不同的组件组成，每一个组件负责一块特定功能。

> 横切关注点，会跨越系统的多个组件。

AOP能确保POJO的简单性。AOP能够使这些服务模块化，并以声明的方式将它们应用到它们**需要影响**的组件中去。所造成的结果就是这些组件会具有更高的内聚性并且会更加
关注自身业务，完全不需要了解设计系统服务所带来的复杂性。

借助AOP，可以使用各功能层去包裹核心业务层。功能层以声明的方式灵活地应用到系统中。

> 在基于Spring的应用中，应用对象生存于**Spring 容器(Container)**中。SPring容器负责创建对象、装配它们，配置它们并管理它们的整个生命周期。

容器是Spring的核心。Spring容器使用`DI`管理构成应用的组件，它会创建相互协作的组件之间的关联。
Spring自带多个容器的实现，可以归纳为两种不同的类型：
1. `bean`工厂，由`org.springframework.beans.factory.BeanFactory`接口定义，是最简单的容器，提供基本的`DI`操作。
2. 应用上下文，由`org.springframework.context.ApplicationContext`接口定义，基于`BeanFactory`构建，并提供应用框架级别的服务。

### 应用上下文

Ｓpring自带多种类型的应用上下文：
* `AnnotationConfigApplicationContext`,从一个或多个基于`Java`的配置类中加载`Spring`应用上下文。
* `AnnotationConfigWebApplicationContext`，从一个或多个基于`Java`的配置类中加载`Spring Web`应用上下文。
* `ClassPathXmlApplicationContext`,从类路径下的一个或多个`XML`配置文件中加载上下文，把应用上下文的定义文件作为**类资源**。这些配置文件的根目录
为`resources`，与`main。java`平级的目录。**在所有类路径下查找配置文件**
* `FileSystemXmlApplicationContext`，从文件系统下的一个或多个`XML`配置文件中加载上下文定义。
* `XmlWebApplicationContext`,从`Web`应用下的一个或多个`Xml`配置文件中加载上下文定义。

### bean的生命周期

1. `Spring`对`bean`进行实例化。
2. `Spring`将值和对`bean`的引用注入到`bean`对应的属性中。
3. 如果`bean`实现了`BeanNameAware`接口，Ｓpring将`bean`的`ID`传递给`setBeanName()`方法。
4. 如果`bean`实现了`BeanFactoryAware`接口，Ｓpring将调用`setBeanFactory()`方法，将`BeanFactory`容器实例传入。
5. 如果`bean`实现了`ApplicationContextAware`接口，Ｓpring将调用`setＡpplicationContext()`方法，将`bean`所在的应用上下文的引用传入进来。
6. 如果`bean`实现了`BeanPostProcessor`接口，Spring将调用它的`postProcessBeforeInitialization()`方法。
7. 如果`bean`实现了`InitializingBean`接口，Spring将调用它的`afterPropertiesSet()`方法。类似的，如果`bean`使用`init-method`声明了初始化方法，该方法也会被调用。
8. 如果`bean`实现了`BeanPostProcessor`接口，Spring将调用它的`postProcessAafterInitialization()`方法。
9. 此时，`bean`就已经准备就绪了，可以被应用程序使用。它们将**一直驻留在应用上下文中，**直到该应用上下文被销毁。
10. 如果`bean`实现了`DisposableBean`接口，Spring将调用它的`destroy()`方法。同理地，如果`bean`使用`destroy-method`声明了销毁方法，该方法也会被调用。


## Spring 模块

Spring按功能可以划分为6类不同的功能：
* Spring核心容器。
* Spring AOP 模块。
* 数据访问与集成。
* Web 与远程调用。
* Instrumentation。
* 测试。