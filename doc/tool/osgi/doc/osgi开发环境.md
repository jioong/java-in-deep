# OSGI 开发环境

## 开发环境搭建

### 1. Bundle 管理:Nexus

1. 利用*Maven*厂库来管理*Bundle*，因为*bundle*也是JAR包。
2. 获取依赖的*bundle*。
3. 管理自身构建的*bundle*。

### 2. OSGI 项目构建:POM

1. 定义全局属性。
2. 每个*bundle*作为一个`Module`。
3. *Maven Bundle Plugin*。
4. 将*bundle*依赖放在单独的POM中，依赖POM的组合与继承。
5. 