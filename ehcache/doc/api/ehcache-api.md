# Ehcache API

## Cache<K, V> 接口

它定义了**创造、获取、更新、删除**缓存的所有操作。它会基于`key`去查找`value`。
一个`cache`不是一个`map`，因为以下两点原因：
1. `Eviction`，一个`cache`会有容量限制，它可能会在任何时间点移除一个`cache`。注意，*Eviction*可能在达到容量的最大值之前发生。
2. `Expiry`，`cache`中的数据可以配置达到一定的时间后会过期。

### 方法

1. `clear(): void`，删除缓存中的所有数据。
2. `containsKey(K key): boolean`
3. `get(K key): V`
4. `getAll(Set<K> keys): Map<K, V>`，返回所有指定key的值。  
5. `put(K keey, V value): void`

## Cache.Entry<K,V> 接口

表示存储在`Cache`中的一个键值映射。

## CacheManager 接口

它是管理`Cache`的仓库并联合`Service`。

### 方法

1. `createCache(String alias, Builder<? extends CacheConfiguration<K,V>> configBuilder): Cache<K, V>`,用指定的`CacheConfiguration`
    创造一个`Cache`。
2. `getCache(java.lang.String alias, java.lang.Class<K> keyType, java.lang.Class<V> valueType)： Cache<K, V>`,
    用指定的alias索引`Cache`。
3. `getStatus()： Status`，获取当前状态。
4. `init(): void`，将其状态装换为`AVAILABLE`。
5. `removeCache(java.lang.String alias): void`，删除指定的`Cache`。

## Status 枚举

该枚举用于表示`CacheManager`和`UserManagedCache`的状态。

其中，
1. `UNINITIALIZED`，表示还没有准备好被使用。
2. `MAINTENANCE`，表示独占访问允许限制的操作。
3. `AVAILABLE`，表示准备好被使用。

状态间的转换包括：
1. `UNINITIALIZED to AVAILABLE`，当转换失败时会保留原有张态。
2. `AVAILABLE to UNINITIALIZED`，当转换失败时也会变为`UNINITIALIZED`状态。
3. `UNINITIALIZED to MAINTENANCE`，当转换失败时会保留原有张态。
4. `MAINTENANCE to UNINITIALIZED`，当转换失败时也会变为`UNINITIALIZED`状态。

## PersistentCacheManager 接口

它继承了`CacheManager`。它能管理当JVM停止时`Cache`的生命周期。

### 方法

1. `destroy(): void`，销毁与该管理器所关联的所有持久化数据。它会先进入`MAINTENANCE`状态，然后执行销毁，再退出`MAINTENANCE`状态。
2. `destroyCache(String alias)`，销毁指定Cache。

## PersistentUserManagedCache<K,V>接口

