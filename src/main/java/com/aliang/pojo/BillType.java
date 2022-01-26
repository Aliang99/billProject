package com.aliang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("bill_type_")
@Data
public class BillType {

    @TableId(value = "id_",type=IdType.AUTO)
    private Long id;

    @TableField("name_")
    private String name;
}
