package com.jzli.sharding.demo.service.impl;

import com.jzli.sharding.demo.entity.Student;
import com.jzli.sharding.demo.mapper.StudentMapper;
import com.jzli.sharding.demo.service.IStudentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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
public class StudentServiceImpl implements IStudentService {
    @Resource
    public StudentMapper studentMapper;

    @Override
    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0;
    }
}
