package com.wmh.test;

import com.wmh.domain.Demo2;
import com.wmh.domain.Demo3;
import com.wmh.service.DemoService2;
import com.wmh.service.DemoService3;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

/**
 * @author weimenghua
 * @time 2022-12-04 09:03
 * @description 测试Demo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoApplicationTest {
    @Autowired
    private DemoService2 demoService2;
    @Autowired
    private DemoService3 demoService3;

/*
    @Before
    public void setUp(){
        demoService2.deleteAllDemo2();
    }
*/

    @Test
    public void testJdbcTemplate() throws Exception{
        demoService2.create("测试jdbcTemplate1", "123456");
        demoService2.create("测试jdbcTemplate2", "123456");
        demoService2.create("测试jdbcTemplate3", "123456");

        List<Demo2> demo2List = demoService2.getByUserName("测试jdbcTemplate1");
        Assert.assertEquals("123456", demo2List.get(0).getPassword());
        Assert.assertEquals(3, demoService2.getAllDemo2());
        demoService2.deleteByUsername("测试jdbcTemplate3");
        Assert.assertEquals(2, demoService2.getAllDemo2());
    }

    @Test
    public void testJPA() throws Exception{
//        demoService3.deleteAll();
//        demoService3.save(new Demo3("测试JPA", "111111"));
        Demo3 demo3 = demoService3.findByUsername("测试JPA");
        System.out.printf("第一次查询：", demo3.getUsername());
        System.out.printf("第一次查询：", demo3.getPassword());
//        Assert.assertEquals(10, demoService3.findAll().size());
    }
}