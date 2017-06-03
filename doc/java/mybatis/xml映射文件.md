# xml 映射文件

## Mapper XML 文件

**SQL映射文件**有很少的几个顶级元素(按照它们应该被定义的顺序)：
1. `cache`，给定命名空间的缓存配置。
2. `cache-ref`，其他命名空间缓存配置的引用。
3. `resultMap`，最复杂也最强大的元素，用来描述如何从数据库结果集中加载对象。
4. `sql`，可被其他语句引用可重用语句块。
5. `insert`，映射插入语句。
6. `update`，映射更新语句。
7. `delete`，映射删除语句。
8. `select`，映射查询语句。

## select

select元素有很多属性可以配置，用来决定每条语句的细节。
* `id`，在命名空间中唯一的标识符，可以被用来引用这条语句。
* `parameterType`，将会传入这条语句的参数类的**完全限定名或别名**，该属性是可选的。
* `resultType`，返回的期望类型的类的完全限定名或别名。如果是集合情形，应该是集合可以包含的类型，而不是能是集合本身。使用resultType或resultMap，**但不能同时使用**。
* `resultMap`，外部resultMap的命名引用。
* `flushCache`，将其值设置为true,任何时候只要语句被调用，都会导致本地缓存和二级缓存都会被清空，默认值为false。
* `useCache`，将其值设置为true，将会导致本条语句的结果被二级缓存，默认值：对select为true。
* `timeout`，在异常抛出之前，等待数据库返回结果的秒数。默认值为unset，依赖驱动。
* `fetchSize`，每次批量返回的结果行数和这个值相等。
* `statementType`，可选值有STATEMENT,PREPARED,CALLABLE中的一个。默认值为PREPARED。
* `resultsetType`，
* `databaseId`
* `resultOrdered`，仅针对嵌套结果select语句使用。
* `resultSets`，仅对多结果集的情形使用。

## insert, update 和 delete

1. insert
    * id
    * parameterType
    * flushCache
    * statementType
    * keyProperty
    * keyColumn
    * useGeneratedKeys
    * timeout
2. update
    * id
    * parameterType
    * flushCache
    * statementType
    * timeout
3. delete
    * id
    * parameterType
    * flushCache
    * statementType
    * timeout
    
在插入语句里有一些额外的属性和子元素用来处理主键的生成，而且有多种生成方式。
1. 如果数据库支持自动生成主键的字段，那么可以设置`useGeneratedKeys="true"`,然后把`keyProperty`设置到目标属性上就可以了。
2. 如果数据库支持多行插入，还可以传入一个数组或集合，并返回自动生成的主键。
    * 使用 foreach 元素。
    
## sql

这个元素可用来定义可重用的SQL代码段，可以包含在其他语句中，它可以被静态的初始化，不同的属性值通过包含的实例变化。

## 参数

## 字符串替换

默认情况下，使用`#{}`格式的语法会导致MyBatis创建预处理语句属性并安全的设置值，这通常是首选做法。
如果想在SQL中插入不变的字符串，则可以使用`${}`,这样MyBatis不会修改或转义字符串。这种情况会导致SQL注入，因此要么不允许用户输入这些字段，要么自行转义或检查。

## Result Maps

resultMap是其中最重要最强大的元素。它的设计就是**简单语句不需要明确的结果映射，而很多复杂的语句需要描述它们的关系。**

MyBatis会自动创建一个ResultMap，**基于属性名来映射到JavaBean的属性上。**如果列名没有精确匹配，可以在列名的select字句的别名来匹配标签。

## 高级结果映射

### resultMap 元素有很多子元素，概念视图如下：

* constructor，类在实例化时，用来注入结果到构造方法中。
    * idArg，ID参数，标记结果为ID可以帮助提高整体效率。
    * arg，注入到构造方法的一个普通结果。
* id，一个ID结果，标记结果为ID可以帮助提高整体效率。
* result，注入到字段或JavaBean属性的普通结果。
* association，一个复杂的类型关联，许多结果将宝成这种类型。
    * 嵌入结果映射，结果映射自身的关联
* collection，复杂类型的集。
    * 嵌入结果映射。
* discriminator，使用结果值来决定使用哪个结果映射。
    * case，基于某些值的结果映射。
        * 嵌入结果映射。
        
## 自动映射

当自动映射查询结果时，MyBatis会获取SQL返回的列名并在java类中查找相同名字的属性(忽略大小写)。
如果数据库列名使用大写单词加下划线分割单词的方法，而java属性使用驼峰法，为了在这两种命名方式之间映射，则需设置`mapUnderscoreToCamelCase`为true。
在resultMap中如果没有被手工映射，则会被自动映射。**自动映射处理完毕后手工映射才开始处理。**

有三种自动映射等级：
1. NONE，禁用自动映射。仅设置手动映射属性。
2. PARTIAL，将自动映射结果除了那些有内部定义内嵌结果映射的。
3. FULL，自动映射所有。

默认值为`PARTIAL`

## 缓存

要开启二级缓存，需要在SQL映射文件中添加一行
`<cache/>`。

该语句的效果如下：
* 映射语句中的所有select语句将会被缓存。
* 映射语句中的所有insert,update,delete语句将会刷新缓存。
* 缓存会使用LRU最近最少使用算法来回收。
* 根据时间表，缓存不会以任何时间顺序来刷新。
* 缓存会存储列表集合或对象的1024个引用。
* 缓存会被视为read/write可读可写的换粗，意味着对象检索不是共享的，而且可以安全的被调用者修改，而不干扰其他调用者或线程所做的潜在修改。

所有这些都可以通过<cache>的属性来修改。
* eviction，可用的回收策略由：
    * LRU   默认值
    * FIFO
    * SOFT
    * WEAK
* flushInterval（刷新间隔），可以被设置为任意的正整数，单位为毫秒数。默认是不设置的，也就是没有刷新间隔，缓存仅仅调用语句时刷新。
* size（引用数目），可以被设置为任意正整数，要记住缓存的对象的数目和可用内存资源数目，默认值为1024.
* readOnly，只读缓存会给多有调用者返回缓存对象相同的实例。可读写的缓存会返回缓存对象的拷贝，会慢一些,但是安全的。默认为false.