# Spring 注解与XML配置

## 注解

1. `@Component`，表明它修饰的**类**会作为组件类，并告诉Spring要为这个类创建`bean`。
    * 所有使用该注解的类都会创建为`bean`，并且其默认`ID`为首字母变为小写的类名。
2. `@ComponentScan`，该注解能在Ｓpring中启用组件扫描。
    * 如果没有其他配置，`@ComponentScan`默认会扫描与配置类相同的包。
    * 它会查找扫描目录下带有`@Component`注解的类，并在Ｓpring中自动为其创建`bean`。
3. `@Autowired`，声明要进行自动装配。
    * 该注解不仅能够用在构造器上，还可以用在属性的`setter`方法上。其他的方法Spring也会尝试去满足所声明的依赖。
    * 如果没有找到依赖的`bean`，默认会抛出一个异常。如果想要避免抛出异常，可以将该注解的`required`属性设置为`false`。
        此时，如果没有匹配的`bean`，Spring会让这个`bean`处于未装配的状态。
    * 如果由多个`bean`能满足依赖关系的话，Spring会抛出一个异常，表明没有明确指定要选择哪一个`bean`进行自动装配。
    * 该注解可以使用Java依赖注入规范中的`@Inject`注解来替换。
4. `@Configuration`，表明修饰的类为配置类。
    * 当为类添加该注解时，则创建`JavaConfig`类。
5. `@Bean`，该注解会告诉`Spring`它修饰的方法会返回一个对象，该对象要注册为Spring应用上下文中的`bean`，方法体中包含了产生`bean`实例的逻辑。
    * 默认情况下，`bean`的`ID`与带有`@Bean`注解的方法名是一样的。如果想要设置为其他名字，则可以通过该注解的`name`属性指定一个不同的名字。
    * 使用该注解创建的`bean`实例，并注册到Spring应用上下文中。
    * 当调用使用`@Bean`注解修饰的方法时，Spring会拦截所有对方法的调用，并确保直接返回该方法所创建的`bean`，而**不是每次对其进行实际的调用**。
    * 默认情况下，Spring中的`bean`都是**单例的**。
6. `@Import`，该注解用于**JavaConfig类**，用于将一个配置文件导入另一个配置文件。
7. `@ImportResource`,该注解用于将一个XML配置文件导入一个`JavaConfig`配置文件中。
8. `@Profile`,该注解指定某个`bean`属于哪一个`profile`。
    * 如果该注解应用在**类**级别上。它告诉Spring这个配置类中的`bean`只有在指定的`profile`激活时才会创建。如果指定的`profile`没有激活，则带有`@Bean`注解的方法都会被忽略掉。
    * 该注解从3.2开始可以使用在**方法**级别上，与`@Bean`注解一同使用。
    * 没有指定`profile`的`bean`始终都会被创建，与激活哪个`profile`没有关系。
9. `@Conditional`，该注解用在带有`@Bean`注解的方法上，实现条件化的`bean`。
    * 设置给该注解的类是任意实现了`Condition`接口的类。该接口只有一个`matches()`方法
10. `@Primary`，该注解用来标示首选`bean`。
    * 该注解可与`@Component`注解组合用在组件扫描的`bean`上。
    * 也可以与`@Bean`注解组合用在Java配置的`bean`声明中。
    * 它与XML配置文件中的`<bean>`元素的`primary="true"`属性一样。
11. `@Qualifier`,该注解是使用限定符的主要方法。他可以与`@Autowired`和`@Inject`注解协同使用，在注入的时候指定想要注入进去的是哪个`bean`。
    * 该注解的参数为想要注入的`bean`的`ID`。
    * 他可以与`@Component`注解组合使用，设置自己的限定符。
    * 通过`JavaConfig`配置显示定义`bean`的时候，该注解也可以与`@Bean`组合使用。
12. `@Scope`，该注解指定作用域。可以与`@Component, @Bean`注解组合使用。
    * 该注解使用`ConfigurableBeanFactory`类中的范围常量来设置作用域。
    * 它与XML配置文件中的,`<bean>`元素的`scope`属性设置作用域等效。
    * 该注解还有一个`proxyModee`属性。该属性用于解决将会话或请求作用域的`bean`注入单例`bean`中所遇到的问题。
13. `@Value`
    * 它的使用方式与`@Autowired`注解非常相似。
    
    
## XML 配置

1. 使用XML启用自动扫描，可以使用`spring context`命名空间的`<context:component-scan>`元素。

### spring-bean 模式

包含在该模式下的元素:
1. `<beans>`
2. `<bean>`, 类似于`@Bean`注解，通过`class`属性来指定要创建的`bean`的类，需要使用**全限定的类名。**