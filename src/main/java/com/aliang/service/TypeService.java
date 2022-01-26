package com.aliang.service;

import com.aliang.mapper.TypeMapper;
import com.aliang.pojo.BillType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public List<BillType> list(){
        return typeMapper.selectList(null);
    }
}
