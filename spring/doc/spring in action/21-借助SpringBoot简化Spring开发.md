# Spring Boot

它提供4个主要特性，能够改变Spring应用程序的开发方式：
1. Spring Boot Starter，它将常用的依赖分组进行整合，将其合并到一个依赖中，这样就可以一次性添加到项目的依赖中。
2. 自动配置，合理地推测应用所需的bean并自动化配置它们。
3. 命令行接口CLI，发挥了Groovy语言的优势，并结合自动配置进一步简化Spring应用的开发。
4. Actuator，它为Spring Boot应用添加了一定的管理特性。

## 1. 添加Starter依赖

实际上，starter在自己的pom文件中声明了多个依赖。依赖会自动地传递解析。