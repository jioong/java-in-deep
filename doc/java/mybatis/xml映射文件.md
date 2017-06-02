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
