一个好基友问我如何自己实现一个类似于spring的Value注解,想一想觉得也不难啊，趁五一假期写一个，没准以后能够用上呢，哈哈

整个项目通过idea来构建的springboot项目(File->New->Project->Spring initializr),代码结构如下：


```

└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── alioo
    │   │           └── alivalue
    │   │               ├── AliValue.java                    #自定义注解AliValue,类似于Value
    │   │               ├── AliValueBeanPostProcesser.java   #通过BeanPostProcesser方式来完成自定义注解的识别与赋值
    │   │               ├── AlivalueApplication.java         #springboot启动入口类
    │   │               ├── AppConfig.java                   #注入一个bean，用来测试自定义注解
    │   │               └── PropertiesUtil.java              #配置文件工具类，获取配置文件的内容
    │   └── resources
    │       └── application.properties                       #配置文件


```