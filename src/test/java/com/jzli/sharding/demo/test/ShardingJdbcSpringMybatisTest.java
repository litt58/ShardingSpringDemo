package com.jzli.sharding.demo.test;

/**
 * =======================================================
 *
 * @Company 技术中心-共享服务部-后端服务部
 * @Date ：2018/12/28
 * @Author ：李金钊
 * @Version ：0.0.1
 * @Description ：单元测试
 * ========================================================
 */

import com.jzli.sharding.demo.entity.Student;
import com.jzli.sharding.demo.entity.User;
import com.jzli.sharding.demo.service.IStudentService;
import com.jzli.sharding.demo.service.IUserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-database.xml", "classpath*:spring/spring-sharding.xml"})
public class ShardingJdbcSpringMybatisTest {
    @Resource
    public IUserService userService;
    @Resource
    public IStudentService studentService;

    @Test
    public void testUserInsert() {
        User u = new User();
        u.setUserId(11);
        u.setAge(25);
        u.setName("github");
        Assert.assertEquals(userService.insert(u), true);
    }

    @Test
    public void testStudentInsert() {
        Student student = new Student();
        student.setStudentId(21);
        student.setAge(21);
        student.setName("hehe");
        Assert.assertEquals(studentService.insert(student), true);
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAll();
        if (null != users && !users.isEmpty()) {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    @Test
    public void testSQLIN() {
        List<User> users = userService.findByUserIds(Arrays.asList(11));
        if (null != users && !users.isEmpty()) {
            for (User u : users) {
                System.out.println(u);
            }
        }
    }

    @Test
    public void testTransactionTestSuccess() {
        userService.transactionTestSuccess();
    }

    @Test(expected = IllegalAccessException.class)
    public void testTransactionTestFailure() throws IllegalAccessException {
        userService.transactionTestFailure();
    }
}
