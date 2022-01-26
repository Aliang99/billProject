package com.aliang.service;

import com.aliang.pojo.BillType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class TypeServiceTest {

    @Autowired
    private TypeService service;

    /**
     * 测试获取账单的全部类型
     * 测试结果：OK
     */
    @Test
    void list() {
        List<BillType> list = service.list();
        System.out.println(list);
    }
}