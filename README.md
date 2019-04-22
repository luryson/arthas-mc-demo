## 复现arthas `mc`命令无法编译某些的场景

### 背景:

    使用jar、war运行时无法编译，但使用ide或者mvn spring-boot:run运行时可以编译

    登录arthas后执行一下命令:
    1. sc com.sigh.arthas.demo.AListener | grep classLoaderHash
    2. jad --source-only com.sigh.arthas.demo.AListener > /tmp/AListener.java
    3. mc -c 1d56ce6a /tmp/AListener.java -d /tmp
