# OSGI 模块层

模块化与面向对象的区别：
* 都是**关注点分离**(分治)思想
* 关注的**粒度**不一样
    * 当实现一个特定的功能时，关注的是类与类之间的关系。
    * 当将相关的类逻辑上组织在一起时，关注的是系统的模块，以及模块之间的关系。

## Bundle

*Bundle*是一个包含了代码、资源和元数据，以JAR的形式存在的一种模块化单元，JAR文件的边界同时作为运行时逻辑模块的封装边界。

*Bundle*的逻辑模块性：
* 通过包的可见性对类进行了封装。

*Bundle*的物理模块性：
* JAR包的*bundle*的物理格式。
* *bundle*是一个物理部署的单元。
* *Manifest.mf*文件保存模块性的元数据。

## 定义元数据

元数据信息定义在*META-INF/Manifest.mf*中，它由三类标记：
* 可读信息。
* *Bundle*标识identification。
* 代码可见性。

### Manifest.mf 文件

*Manifest*文件的格式：
* 属性声明的一般形式为:*name: value*。
* 一行不超过 72 个字符，下一行继续则由单个空格字符开始。
* 每个子句(clause)进一步分解为一个目标(target)和一组由分号分割的*name-value*对参数。

### Bundle 标识

1. *Bundle-SymbolicName*
2. *Bundle-Version*
3. *Bundle-ManifestVersion*
    * 唯一的有效值为 2
    * 没有*Bundle-ManifestVersion*的*bundle*不要求指定*Bundle-SymbolicName*属性
4. *Bundle-ClassPath* 内部类路径
    * 如果不指定，默认为**.**，即该*bundle*根目录下的所有包
    * 一旦指定该属性，则需显示加入**.**
    * 按照声明的顺序搜索*bundle*类路径条目
    * 一些静态资源可以放到专门的文件夹下
    * *bundle*所依赖的JAR包，如果不容易更改或者为了避免共享，可以内嵌在*bundle*中
    * 内嵌JAR包，一定程度上会影响性能，建议将内嵌的JAR包转换为*bundle*
5. *Export-Package* 导出的内部代码，也就是提供的能力
    * 标准JAR文件默认公开一切内容，而*bundle*默认不公开任何内容
    * 可以导出多个包，用逗号隔开
    * 可以给导出包增加任何属性
    * 可以给导出包设置*Version*，默认值为0.0.0
6. *Inport-Package* 导入的外部代码，也就是依赖的服务。
    * 导入一个包，并没有导入它的子包
    * 可以通过属性导入特定的包
        * 对于任意属性，OSGI只支持相等匹配
    * 除`java.*`
    
    
**OSGI类的查找顺序:**
1. 如果类所在的包以`java.`开头，委托给父类加载器。
2. 如果类所在的包在导入包中，委托给导出该包的`bundle`。
3. 在`bundle`自身的类路径上查找。

**依赖解析:**
* 只有满足所有的依赖，*bundle*才可用。
* OSGI框架最重要的任务之一是：通过自依赖解析自动化地进行依赖管理。
* 级联解析。
* 多个*bundle*满足*import-package*时：
    * 已解析的(resolved)*bundle*优先级高，为解析的(installed)*bundle*优先级低
    * 相同优先级有多个匹配时，版本高者优先，版本相同则选最先安装的*bundle*
    
**类空间的一致性:**
一个*bundle*只能看到某个*Package*的唯一一个实例。