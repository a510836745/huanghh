package com.neu.shop.mybatis;

import com.neu.shop.dao.AdminMapper;
//import com.neu.shop.dao.DepartmentMapper;
import com.neu.shop.pojo.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {

    /*@Autowired(required = false)
    DepartmentMapper departmentMapper;*/

    @Autowired(required = false)
    AdminMapper adminMapper;

    /**
     * 测试DepartmentMapper
     */
    @Test
    public void testInsertSelective() {


        System.out.println(adminMapper.selectByName(new Admin(null,"root","root")));

    }

}
