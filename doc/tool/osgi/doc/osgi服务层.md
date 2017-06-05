# OSGI 服务层

服务的定义：为别人完成工作。
服务是指提供者与使用者之间的契约：
* 服务可以被替代
    * 能够绑定到不同的实现
* 服务需要被发现
    * 能够被别人找到
* 服务需要被标识
    * 能够被发布出来
    
![OSGI 服务](./img/service-layer-service.jpg "OSGI服务")

使用者不需要关心服务的具体实现，甚至不关心是谁提供的服务，只要遵守约定的契约即可。

## 面向服务的设计

* 降低服务提供者与使用者之间的耦合，这样更容易**重用**组件。
* 更强调接口(抽象的)而不是实现类(具体的)。
* 清晰描述依赖关系，让你知道一切是如何结合在一起的。
    * 可以有附加的元数据描述。
* 支持多个相互竞争的服务实现，可以互换这些实现。
    * 动态替换。

**OSGI服务**
OSGI框架拥有一个集中的服务注册中心，它遵循**发布---查询---绑定**模型。
    * 提供者*bundle*可以将*POJOs*发布为服务。
    * 使用者*bundle*可以找到并绑定服务。
![OSGI 服务发布绑定](./img/service-layer-publish-find.jpg "OSGI服务发布绑定")

**服务注册、更新与注销**
* 服务注册对象是私有的，不能被别的*bundle*共享，它们与发布服务的*bundle*的生命周期是绑定的。
* OSGI将会接受以具体类名注册的服务，但是不推荐这样做。
* 当一个*bundle*停止时，任何没有被移除的服务都会被框架自动移除。当*bundle*停止时，不必明确地注销服务。

**查找和绑定服务**
* 多个服务排序
    * 先按`service.ranking`由大到小排序，然后再按`service.id`有小到大排序。
* 按属性查询
    * 使用`LDPA`过滤字符创。

**服务使用**
* 返回的实现通常与之前注册中心注册的POJO实例完全相同。
    * 但是OSGI规范没有禁止使用代理和封装。
* 每次调用`getService()`时，注册中心会增加一个使用计数。当完成一个服务时，应该告诉注册中心。
* 一般不要用成员变量存储服务。

**服务监听**
* OSGI框架为服务事件提供了一个简单而灵活的API
```Java
public interface ServiceListener extends EventListenr {
    public void serviceChanged(ServiceEvent event);
}
```

* 三种类型的事件：
    * `REGISTERED`(注册)：一个服务已经被注册并且可以被立即使用。
    * `MODIFIED`(更改)：服务的一些元数据已经被修改。
    * `UNREGISTERED`(注销)：一个服务处在被注销的状态中。
![服务改变事件](./img/service-layer-event.jpg "服务改变事件")

**服务追踪器**
* *bundle*是动态的，服务随时可能消失。
    * 调用时需要判断服务是否为`null`
* 使用`Listener`。
    * 服务注销时，告知调用者
    * 先于`Listener`注册之前的服务无法监听到
* 更简洁的`ServiceTracker`。

**服务工厂**
* 当需要为不同的*bundle*提供相同服务的不同实例。
* 同一个*bundle*的多次请求会被OSGI框架缓存。
* 什么时候清理缓存：
    * 当服务使用*bundle*的`unGetService`调用次数等于`getService`次数时。
    * 当服务使用*bundle*停止时。
    
**服务钩子**
* 服务钩子*Service Hook*也是一种OSGI服务。
* `EventListenerHook`
    * 当所有服务事件发生时。
* `FindHook`
    * 当服务请求发生时。
* `ListenerHook`
    * 当服务注册或者注销发生时。
* 服务钩子可以实现一些AOP功能
    * 比如增强服务，返回服务的代理。
    
**OSGI标准服务**

![OSGI标准服务](./img/service-layer-standard-service.jpg "OSGI标准服务")