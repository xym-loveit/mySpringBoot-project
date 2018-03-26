package com.xym.springboot;

import com.xym.springboot.enums.Events;
import com.xym.springboot.enums.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.statemachine.StateMachine;

/**
 * 在run函数中，我们定义了整个流程的处理过程，其中start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，然后通过调用sendEvent(Events.PAY)执行支付操作，最后通过掉用sendEvent(Events.RECEIVE)来完成收货操作
 * <p>
 * <p>
 * 通过本例，我们可以对如何使用Spring StateMachine做如下小结
 * 定义状态和事件枚举
 * 为状态机定义使用的所有状态以及初始状态
 * 为状态机定义状态的迁移动作
 * 为状态机指定监听处理器
 *
 * @author xym
 */
@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).run(args);
    }

    @Autowired
    private StateMachine<States, Events> stateMachine;

    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }
}
