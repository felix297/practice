# 遇到的问题 

使用自定义的类代替 `@Qualifier` 的话，用法是跟 `@Qualifier` 是一样的：给被注入的 bean 加上 `@Qualifier` 注解，也要给要注入这个 bean 的类相应的位置加上 `@Qualifier` 注解。