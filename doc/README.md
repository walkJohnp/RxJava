## 代码结构

- annotations  // 注解
- exceptions   //异常目录
- functions    //封装行为，Action5,代码该类封装了5个操作
- observables    // 被观察者, 也叫生产者
- observers      // 观察者, 对基础响应式类和接口的包装以及实现
- plugins      // 对响应式的生命周期进行钩子操作 
- scheduler    // 调度器的实现
- singles      // 继承了single响应式的class
- subjects     // 既是观察者也是被观察者的class
- subscriptions // 资源管理器的实现