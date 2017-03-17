# Collection

该接口为集合类层级结构的根。一个集合表示一组对象，也就是**元素**。  
* 一些集合允许存在**重复的**元素，一些集合则不允许。  
* 一些集合元素是**有序的**,一些集合元素则是**无序的**。  
* JDK没有提供该接口的任何**直接**的实现，但是提供了该接口的子接口的具体实现类。 
* 所有该接口的直接或间接的实现类需要提供两个构造器：
    1) 一个无参构造器，用于创造一个空的集合。
    2) 只有一个且参数类型为`Collection`的参数，用于创造一个与参数中元素一样的集合。
    
## 方法

1. size(): int
2. isEmpty(): boolean
3. contains(Object): boolean
4. iterator(): Iterator<E>
5. toArray(): Object[]
6. toArray(T[]): T[]
7. add(E): boolean
8. remove(Object): boolean
9. containsAll(Collection<?>): boolean
10. addAll(Collection<? extends E>): boolean
11. removeAll(Collection<?>): boolean
12. removeIf(Predicate<? super E>): boolean
13. retainAll(Collection<?>): boolean
14. clear(): void
15. equals(Object): boolean
16. hashCode(): int
17. spliterator(): Spliterator<E>
18. stream(): Stream<E>
19. parallelStream(): Stream<E>