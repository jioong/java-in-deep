# 框架简介

Spring框架提供了众多的基础设施用于支持简化Java应用的开发，以便开发者不用关心基础设施而只需关注核心的业务逻辑。

## 模块

![Spring 模块](./img/spring-framework.png "Spring 模块结构")

### 核心容器

*Core Container*由`spring-core, spring-beans, spring-context, spring-context-support, spring-expression`模块组成。
其中，`spring-core, spring-beans`提供了框架的基础能力，如*IOC和DI*特性。
*Context*则是构建在`Core, Bean`模块之上
