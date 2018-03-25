package com.xym.springboot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author xym
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

}
