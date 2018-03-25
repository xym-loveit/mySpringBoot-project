package com.xym.springboot.service;

import com.xym.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author xym
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据方法名自动创建sql
     *
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * 根据方法名自动创建sql
     *
     * @param name
     * @param age
     * @return
     */
    User findByNameAndAge(String name, Integer age);

    /**
     * 自定义sql
     *
     * @param name
     * @return
     */
    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);

}
