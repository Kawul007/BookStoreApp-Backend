package com.Kawul.BookStoreApp.service;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.Kawul.BookStoreApp.bean.Collection;
import com.Kawul.BookStoreApp.dao.BookItemMapper;
import com.Kawul.BookStoreApp.dao.CollectionMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements CollectionService {
   @Autowired
   private CollectionMapper collectionMapper;

   @Autowired
   private BookItemMapper bookItemMapper;
    @Override
    public Boolean assignBook(Integer bookId, Integer userId) {
                Collection collection = collectionMapper.selectOne(
                new LambdaQueryWrapper<Collection>().eq(Collection::getBook_id, bookId)
                        .eq(Collection::getUser_id, userId)
        );
                if (collection==null){
                    Collection collection1 = new Collection();
                    collection1.setBook_id(bookId);
                    collection1.setUser_id(userId);
                    int i = collectionMapper.insert(collection1);
                return true;
                }else{
                    return false;
                }

    }

    /**
     * 根据用户id获取收藏的书本
     * @param userId
     * @return
     */
    @Override
    public List<BookItem> getCollectionBook(Integer userId) {
        List<Collection> collectionList = collectionMapper.selectList(new LambdaQueryWrapper<Collection>().eq(Collection::getUser_id, userId));
        List<Integer> collect = collectionList.stream().map(Collection::getBook_id).collect(Collectors.toList());
        List<BookItem> list = collect.stream().map(e -> bookItemMapper.selectOne(new LambdaQueryWrapper<BookItem>().eq(BookItem::getBook_id, e))).collect(Collectors.toList());

        return list;
    }

    @Override
    public Boolean cancleCollection(Integer bookId, Integer userId) {
        int i = collectionMapper.delete(
                new LambdaQueryWrapper<Collection>().eq(Collection::getBook_id, bookId).eq(Collection::getUser_id, userId)
        );
        return i > 0;
    }
}
