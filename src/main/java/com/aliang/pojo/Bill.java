package com.aliang.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.util.Date;

@Data
@TableName("bill_")
public class Bill {
    @TableId(type= IdType.AUTO,value = "id_")
    private long id;
    @TableField("title_")
    private String title;
    @TableField("bill_time_")
    private Date billTime;
    @TableField("type_id_")
    private Long typeId;
    @TableField("price_")
    private Double price;
    @TableField("explain_")
    private String explain;

    /**
     * 查询条件封装
     */
    @TableField(exist = false)
    private String typeName;
    //@Transient
    @TableField(exist = false)
    private Date beginTime;
    //@Transient
    @TableField(exist = false)
    private Date endTime;
}
