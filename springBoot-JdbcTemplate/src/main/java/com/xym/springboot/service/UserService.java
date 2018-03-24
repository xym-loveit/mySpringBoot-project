package com.xym.springboot.service;

/**
 * @author xym
 */
public interface UserService {
    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     */
    void create(String name, int age);

    /**
     * 根据name删除一个用户
     *
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总量
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void deleteAllUsers();
}
