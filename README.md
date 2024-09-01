# 个人练习仓库

记录练习记录。

# 常用依赖

## spring 都有哪些包

[api 文档中可以看到有哪些包](https://docs.spring.io/spring-framework/docs/5.3.31/javadoc-api/)

另外的参考：[参考](https://blog.csdn.net/dongyang2019/article/details/113726740)

## 个人常用依赖的版本

本人使用的依赖的版本都是 `spring-boot-dependencies 2.7.18` 中的版本。

```xml
<!-- 版本汇总 -->
<spring-context.version>5.3.31</spring-context.version>
<lombok.version>1.18.30</lombok.version>
<junit.version>4.13.2</junit.version>
```

### spring 相关依赖

```xml
<!-- spring context 依赖：普通java工程使用spring框架只需引入这一个就够了 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>${spring-context.version}</version>
</dependency>

<!-- spring aop 依赖 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>5.3.31</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.3.31</version>
</dependency>

<!-- springmvc 依赖 -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.31</version>
</dependency>


<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.12.0</version>
</dependency>
```

### 其他依赖

```xml
<!-- lombok 依赖  -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>${lombok.version}</version>
</dependency>

<!-- junit 框架 -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>${junit.version}</version>
</dependency>
```

### exclusions 排除依赖

因为 spring-core 依赖了 commons-logging，而其他模块都依赖了 spring-core，所以整个 spring 框架都依赖了 commons-logging，如果有自己的日志实现如 log4j，可以排除对 commons-logging 的依赖，没有日志实现而排除了 commons-logging 依赖，编译报错。

# xml 文件模板

1. 最基础的 `bean.xml`

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
            https://www.springframework.org/schema/beans/spring-beans.xsd">

    </beans>
    ```

2. Annotation-based Container Configuration

    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context"
        xsi:schemaLocation="http://www.springframework.org/schema/beans
            https://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/context
            https://www.springframework.org/schema/context/spring-context.xsd">

        <context:annotation-config/>

    </beans>
    ```
# 其他

1. Lombok 导致 spring bean 的 `scopt=prototype` 设置不生效

    使用了 `@Data` 之后导致 `scopt=prototype` 设置不生效，而 lombok 中的其他注解则不会。

    另外请参见：[参考](https://wenku.csdn.net/answer/896aff3cc29f48b38c4fb2faf301b2b7)
