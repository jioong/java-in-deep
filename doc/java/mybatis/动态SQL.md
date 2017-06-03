# 动态SQL

## if

动态SQL通常要做的事情是有条件的包含where字句的一部分。

## choose, when, otherwise
 
 choose元素有点像switch。
 ```java
 <choose>
    <when>
    </when>
    <when>
    </when>
    <otherwise>
    </otherwise>
 </choose>
 ```
 
 ## trim, where, set
 
 where元素只有在一个以上的if条件有值的情况下才去插入`where`字句，而且，若最后的内容是`and ,or`开头的，where元素也知道怎么将它们去除。
 如果where元素没有按照正常套路，可以通过自定义trim元素来定制我们想要的功能
 
 set元素可被用于动态包含需要更新的列，而舍去其他。set元素会动态设置SET关键字，并消除无关的逗号。
 
 ## foreach
 
 对一个集合进行遍历。可以将任何可迭代对象和任何字典或数组对象传递给foreach作为集合参数。当使用可迭代对象或数组时，index是当前迭代的次数，item是本次迭代获取的值。
 如果是字典，index是键，item是值。