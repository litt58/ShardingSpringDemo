package com.jzli.sharding.demo.service;

import com.jzli.sharding.demo.entity.User;

import java.util.List;

/**
 * =======================================================
 *
 * @Company 技术中心-共享服务部-后端服务部
 * @Date ：2018/12/28
 * @Author ：李金钊
 * @Version ：0.0.1
 * @Description ：
 * ========================================================
 */
public interface IUserService {
     boolean insert(User u);

     List<User> findAll();

     List<User> findByUserIds(List<Integer> ids);

     void transactionTestSuccess();

     void transactionTestFailure() throws IllegalAccessException;
}
