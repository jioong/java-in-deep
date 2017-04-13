# SPI 机制

SPI的全称是`Service Provider Interface`，这个是针对厂商或者插件的。java spi提供这样一种机制：为某个接口寻找服务实现的机制。有点类似IOC思想。

java spi的具体约定为：当服务的提供者，提供了服务接口的一种实现之后，在jar包的`META-INF/services/`目录里同时创建一个以服务接口命名的文件。该文件里就是
实现该服务接口的具体实现类。当外部程序装配这个模块的时候，就能通过该jar包`META-INF/services/`里的配置文件找打具体的实现类名，并装载实例化，完成模块的注入。
