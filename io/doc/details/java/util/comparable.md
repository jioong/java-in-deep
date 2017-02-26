# Comparable API

该接口会在每个实现它的类的对象上加上一个排序的方法。该排序会参考类的自然排序*natural ordering*，并且这个类的`compareTo`方法会参考它的自然比较方法。
实现该接口的`List`或数组*array*对象，能通过`Collections.sort(list), Arrays.sort()`方法自动排序。
实现该接口的对象可以作为`SortedMap`的*key*，或者`SortedSet`的元素,不需要指定特定的`Compartor`对象。

对于类`C`的自然排序也就是**一致且相等**意味着当且仅当`C`中的每个元素`e1, e2`满足e1.compareTo(e2) == 0`与`e1.equals(e2)`有相同的布尔值结果。

注意，**`null`不是任何类的实例**,`e.compareTo(null)需要抛出`NullPointerException`,即使`e.equals(null)`返回`false`。
