package com.xym.springboot.controller;

import com.xym.springboot.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author xym
 */
@RestController
@RequestMapping("users")
public class UserController {

    /**
     * 创建线程安全的map
     */
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    /**
     * 获取用户列表
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<User> getUserList() {
        ArrayList<User> users = new ArrayList<User>(UserController.users.values());
        return users;
    }


    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        users.put(user.getId(), user);
        return "success";
    }


    /**
     * 根据用户id获取用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }

    /**
     * 根据用户id和参数更新用户信息
     *
     * @param id
     * @param user
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        User user1 = users.get(id);
        user1.setName(user.getName());
        user1.setAge(user.getAge());
        users.put(id, user1);
        return "success";
    }


    /**
     * 根据用户id删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        users.remove(id);
        return "success";
    }

}
