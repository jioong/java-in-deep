# dom4j

## DOM(Document Object Model)

DOM 就算是文档对象模型，在应用程序中，基于DOM的XML分析器将一个XML文档转换成一个对象模型的集合，应用程序通过对这个对象模型的操作，来实现对XML文档数据的操作。

DOM分析器把整个XML文档转换为DOM树放在内存中，当文档较大或结构比较复杂时，对内存的需求比较高。此外，对于结构复杂的树的遍历也是一项耗时的工作。

> DOM就是一个对象化的XML数据接口，一个与语言无关、与平台无关的标准接口规范。

文档代表的是数据，而DOM则代表如何去处理这些数据。

### DOM 模型结构

最常见的节点类型：
1. **元素**，是XML的基本构建。
    * 元素可以有其他元素、文本节点或两者兼有作为其子节点。
    * 元素节点是**可以有属性**的唯一类型的节点。
2. **属性**，包含关于元素节点的信息，但实际上，不认为它是元素的子节点。
3. **文本**，可以包含许多信息或仅仅是空白。
4. **文档(根节点)**，是整个文档中所有其他节点的父节点。



## 创建Document文档的三种方式

1. 通过读入XML文件创建Document对象。
```java
SAXReader reader = new SAXReader();
Document doc = reader.read(new File("path/to/xml/file"));
```
2. 通过解析XML形式的文本，创建。
```java
String xml = "content_of_xml";
Document doc = DocumentHelper.readText(xml);
```
3. 主动创建Document对象。
```java
Document doc = DocumentHelper.createDocument();
```
