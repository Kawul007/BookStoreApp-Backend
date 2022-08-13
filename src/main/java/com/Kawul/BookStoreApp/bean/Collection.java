package com.Kawul.BookStoreApp.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 收藏表
 */
@Data
@TableName("collection")
public class Collection {

    @TableId(type =IdType.AUTO)
    private Integer collection_id;

    private Integer book_id;

    private Integer user_id;
}
