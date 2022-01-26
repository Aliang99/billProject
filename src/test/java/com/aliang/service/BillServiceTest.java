package com.aliang.service;

import com.aliang.pojo.Bill;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BillServiceTest {

    @Autowired
    private BillService service;

    /**
     * 测试账单数据的分页：
     * 测试结果：OK
     */
    @Test
    void getPage() {
        Bill bill =new Bill();

        PageInfo<Bill> page = service.getPage(null, 1, 5);
        System.out.println(page.getList());
    }
}