package com.xym.springboot.controller;


import com.xym.springboot.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xym
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }


    /**
     * 错误信息以json格式返回
     * @return
     * @throws MyException
     */
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

}
