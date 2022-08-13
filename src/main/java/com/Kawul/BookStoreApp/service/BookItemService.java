package com.Kawul.BookStoreApp.service;

import com.Kawul.BookStoreApp.bean.BookItem;

import java.util.List;

public interface BookItemService {
    //上架新书
    int saveBookItem(BookItem bookItem);
    //获取数据
     List<BookItem> findAll();
    //删除数据
     int delete(int book_id);


//    //设置库存量为0，标记为缺货
//    int update(int book_storage);

    //更新数据
     int update(BookItem bookItem);

     int updateStorage(BookItem bookItem);

    BookItem getBookItemById(Integer id);

    /**
     * 根据书名获取书的相关信息
     * @param name
     * @return
     */
    List<BookItem>  getBookIdByName(String name);

    List<BookItem> getBookByStatus(String typeName);

    List<BookItem> getBookOrderByDate();


}