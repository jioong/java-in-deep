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

**构造器注入bean引用**

当`Spring`遇到`<bean>`元素时，它会创建一个对象实例。`<constructor-arg>`元素会告知Spring要将一个`ID`为`ref`属性指定的`bean`的引用传入该`bean`。

作为`<constructor-arg>`的替代方案，可以使用`c-命名空间`，它是在XML更为简洁地描述构造器参数的方式。要使用它的话，必须在XML的顶部声明其模式:
```XML
    xmlns:c="http://www.springframework.org/schema/c"
    
    <bean id="CDPlayer" class="com.github.jioong.basic.spring.in.action.CD.impl.CDPlayer">
        <constructor-arg ref="compactDisc" />
    </bean>
```

在`c-命名空间`和模式声明之后，就可以使用它来声明构造器参数了。如
```XML
<bean id="CDPlayer" class="com.github.jioong.basic.spring.in.action.CD.impl.CDPlayer" c:cd-re="compactDisc" />
```
它与上面的`<constructor-arg>`注入等效。

`c-命名空间`作为`bean`元素的一个属性。该属性名的组成规则如下：
* 属性名为`c:`开头，也就是此命名空间的前缀。
* 接下来，是要装配的构造器参数名。
* 之后的，`-ref`则是一个命名约定。它告诉Spring,正在装配的是一个`bean`的引用。
* 该属性的值则是要注入的`bean`的`ID`。

上面的方式直接使用了构造器参数名称，可能是优化问题导致无法正常执行。替代方案是，**使用参数在整个参数列表中的位置信息:**
```XML
<bean id="CDPlayer" class="com.github.jioong.basic.spring.in.action.CD.impl.CDPlayer" c:_0-re="compactDisc" />
```

这里**将参数的名称替换成了参数的索引**。因为在XML中不允许数字作为属性的第一个字符，所以必须添加一个下划线作为前缀。


**将字面量注入到构造器中**

使用`<constructor-arg>`的`value`属性，通过该属性表明给定的值要以字面量的形式注入到构造器之中。

同样的，注入字面量值也可以使用`c-命名空间`:
```XML
<bean id="beanName" class="path.to.class" c:_argName1="要传入的值" c:_argName2="要传入的值" />
```
可以看到，装配字面量与装配引用的区别在于**属性名中去掉了 -ref 后缀。**与之前类似，也可以使用参数索引装配字面量值。
```XML
<bean id="beanName" class="path.to.class" c:_0="要传入的值" c:_1="要传入的值" />
```

> XML 中不允许某个元素的多个属性具有相同的名字。

**装配集合**

这种情况，`<constructor-arg>`能实现，但是`c-命名空间`无法做到。

`<constructor-arg><null/></constructor-arg>`会将`null`传递给构造器参数。

要传入集合时：
1. 可以使用`<list>`元素将其声明为一个列表，如
```XML
<constructor-arg>
    <list>
        <value>列表值1</value>
        <value>列表值2</value>
        <value>...</value>
    </list>
</constructor-arg>
```

在`<list>`中可以使用`ref`替换`value`，表明要传入的是`bean`引用列表的装配。

当构造器参数类型是`List`时，使用`<list>`元素是合情合理的。也可以以同样的方式使用`<set>`元素。

### 3.3 设置属性

> 作为通用规则，倾向于对强烈依赖使用构造器注入，而对可选性的依赖使用属性注入。

```XML
<bean id="CDPlayer" class="com.github.jioong.basic.spring.in.action.CD.impl.CDPlayer">
    <peoperty name="要注入的属性名" ref="该属性引用的bean的ID" />
</bean>
```

`<property>`元素为属性的`setter`方法所提供的功能与`<constructor-arg>`元素为构造器所提供的功能是一样的。
此外，Spring提供了与`c-命名空间`类似的`p-命名空间`来作为`<property>`元素的替代方案。为了启动`p-命名空间`必须要在XML文件中与其他的命名空间一起对其进行声明:
```XML
    xmlns:p="http://www.springframework.org/schema/p"
    
    <bean id="CDPlayer" class="com.github.jioong.basic.spring.in.action.CD.impl.CDPlayer" p:compactDisc-ref="compactDisc" />
```

`p-命名空间`中属性名约束与`c-命名空间`中的属性类似。
* 首先，使用`p:`前缀，表明所设置的是一个属性。
* 接下来，是要注入的属性名。
* 最后，属性的名称以`-ref`结尾，表明要注入的是引用，而不是字面量。

**将字面量注入到属性中**

## 4. 导入和混合配置

关于混合配置，第一件需要知道的事情就是在自动装配时，它不在意要装配的`bean`来自哪里。
> 自动装配的时候会考虑到Spring容器中的所有`bean`，而不管它是在`JavaConfig`中或XML中声明的，还是通过组件扫描获取到的。

### 4.1 在JavaConfig中引用XML配置

1. 当存在多个`JavaConfig`配置文件时，可以通过`@Inport`注解将一个配置文件导入另一个配置文件中。如在一个`JavaConfig`配置文件上使用`@Inport(CDConfig.class)`注解。
2. 更好的一种做法是，创建一个比现有`JavaConfig`配置文件更高级别的配置文件，并在这个配置文件类中引入多个配置文件类。如`@Inport({CDPlayerConfig.class, CDConfig.class})`。
3. 使用`@ImportResource`注解，可以将一个XML配置文件导入`JavaConfig`配置文件类中。如`@ImportResource("class-path:cd-config.xml")`。

### 4.2 在XML配置中引用JavaConfig

1. 在XML配置文件中，可以使用`<import>`元素来导入其他的XML配置文件 。如`<import resource="cd-config.xml" />`。该元素只能用于导入其他的XML配置文件，而不能导入`JavaConfig`配置。
2. 将一个`JavaConfig`配置文件导入XML配置文件，需要使用`<bean>`元素。如`<bean class="path.to.JavaConfig">`。

> 不管是使用JavaConfig还是使用XML进行配置，通常会创建一个根配置(root  configuration)。然后在根配置中启用组件扫描。

Spring框架的核心是Spring容器。容器负责管理应用中组件的生命周期，它会创建这些组件并保证它们的依赖能够得到满足。
