package com.Kawul.BookStoreApp.service;

import com.Kawul.BookStoreApp.bean.BookItem;

import java.util.List;

public interface CollectionService {
    Boolean assignBook(Integer bookId, Integer userId);

    /**
     * 根据用户id获取收藏的书本
     * @param userId
     * @return
     */
    List<BookItem> getCollectionBook(Integer userId);

    /**
     * 取消收藏
     * @param bookId
     * @param userId
     * @return
     */
    Boolean cancleCollection(Integer bookId, Integer userId);
}
