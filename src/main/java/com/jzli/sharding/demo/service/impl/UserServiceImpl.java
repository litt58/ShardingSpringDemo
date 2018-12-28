package com.jzli.sharding.demo.service.impl;

import com.jzli.sharding.demo.entity.Student;
import com.jzli.sharding.demo.entity.User;
import com.jzli.sharding.demo.mapper.StudentMapper;
import com.jzli.sharding.demo.mapper.UserMapper;
import com.jzli.sharding.demo.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Service
@Transactional
public class UserServiceImpl implements IUserService {
    @Resource
    public UserMapper userMapper;

    @Resource
    public StudentMapper studentMapper;

    @Override
    public boolean insert(User u) {
        return userMapper.insert(u) > 0;
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public List<User> findByUserIds(List<Integer> ids) {
        return userMapper.findByUserIds(ids);
    }

    @Override
    public void transactionTestSuccess() {
        User u = new User();
        u.setUserId(13);
        u.setAge(25);
        u.setName("war3 1.27");
        userMapper.insert(u);
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        studentMapper.insert(student);
    }

    @Override
    public void transactionTestFailure() throws IllegalAccessException {
        User u = new User();
        u.setUserId(13);
        u.setAge(25);
        u.setName("war3 1.27 good");
        userMapper.insert(u);
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe1");
        studentMapper.insert(student);
        throw new IllegalAccessException();
    }
}
