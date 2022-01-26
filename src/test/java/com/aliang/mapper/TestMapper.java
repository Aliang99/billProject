package com.aliang.mapper;

import com.aliang.pojo.Bill;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMapper {

    @Resource
    private BillMapper mapper;
    private Long time;

    @Before
    public void before(){
        time = System.currentTimeMillis();
    }

    /**
     * 查询全部
     */
    @Test
    public void testQueryAll(){
        List<Bill> bills = mapper.selectList(null);
        bills.forEach(System.out::println);
    }

    /**
     * 根据id查询
     */
    @Test
    public void testQueryOne(){
        Bill bill = new Bill();
        bill.setId(1);
        Bill bill1 = mapper.selectById(1);
        System.out.println(bill1);
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage(){
        //设置分页参数
        Page<Bill> page = new Page<>(1,5);
        //调用分页方法
        Page<Bill> result = mapper.selectPage(page, new QueryWrapper<Bill>().eq("id_", 2)); // TODO:字段名称依然需要填写数据库中的列名
        result.getRecords().forEach(System.out::println);
    }

    /**
     * 打印执行时长
     */
    @After
    public void after(){
        Long time2 = System.currentTimeMillis();
        System.out.println("总用时："+(time2-time)+"ms");
    }

}
