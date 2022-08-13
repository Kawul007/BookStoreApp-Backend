package com.Kawul.BookStoreApp.dao;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookItemMapper extends BaseMapper<BookItem> {
    int updateStorage(BookItem bookItem, LambdaQueryWrapper<BookItem> eq);
//   public String test();
    
}
