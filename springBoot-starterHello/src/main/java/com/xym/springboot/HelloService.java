package com.xym.springboot;

/**
 * 判断依据类，本例根据此类的存在与否创建这个类的Bean，这个类可以是第三方类库的类
 *
 * @author xym
 */
public class HelloService {
    private String msg;

    public String sayHello() {
        return "Hello " + msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
