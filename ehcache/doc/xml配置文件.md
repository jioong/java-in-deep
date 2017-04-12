# XML配置文件

使用XML配置文件可以在创建时配置一个`CacheManager`。

1. 根元素<config>
    XML文件中一个`<config>`元素提供一个`CacheManager`的配置。Ehcache允许在同一个XML文件中配置多个`CacheManager`实例。
2. <service>元素
    该元素为`CacheManager`管理的指定的服务的服务扩展点。每个以这样的方式定义的服务与`CacheManager`有着相同的生命周期。每一个`service`的`Service.start`会在
    `CacheManager.init`过程中调用，`Service.stop`会在`CacheManager.close`时调用。
    这些服务实例能够被`CacheManager`管理的`Cache`实例使用。
3. <default-serializers>元素
    该元素表示`CacheManager`级别的序列化配置，它是一系列的<serializer>元素。
4. <default-copiers>元素
    该元素表示`CacheManager`级别的`Copiers`配置，它是一系列的<copier>元素。
5. <persistence>元素
    该元素会在创建`PersistentCacheManager`时使用，它需要`directory`定位到数据存储到硬盘的地址。
6. <cache>元素
    一个该元素表示一个将被`CacheManager`创建并管理的`Cache`实例。每个该元素需要`alias`属性，会在运行时用于去索取`Cache<K,V>`实例。可选的`uses-template`属性
    可以引用<cache-template>元素的`name`属性。其他可选的嵌套元素：
    1. `<key-type>`，全限定名用于指定缓存key的类型，默认为`java.lang.Object`。
    2. `<value-type>`，全限定名用于指定缓存value的类型，默认为`java.lang.Object`。
    3. `<expiry>`，控制过期类型和它的参数。
    4. `<eviction-advisor>`，全限定名`org.ehcache.config.EvictionAdvisor<K, V> `的实现，默认为`null`。
    5. `<integration>`
    6. `<resources>`，配置存储的各层以及它们的容量。当只使用`on-heap`方式时，能用`<heap>`元素代替它。
7. <cache-template>元素
    `<cache>`元素可以通过该元素的`name`属性继承该元素的所有配置，并`<cache>`可以可选性的覆盖任意的属性，未覆盖的属性则使用该元素中的值。