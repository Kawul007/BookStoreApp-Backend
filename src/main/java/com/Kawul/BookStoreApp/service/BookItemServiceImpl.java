package com.Kawul.BookStoreApp.service;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.Kawul.BookStoreApp.dao.BookItemMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookItemServiceImpl implements BookItemService {
//    @Autowired
//    private BookItemRepository bookItemRepository;
    @Autowired
    BookItemMapper bookItemMapper;
    @Override
    public int saveBookItem(BookItem bookItem) {
        return bookItemMapper.insert(bookItem);//向数据库存储数据
    }
    @Override
    public List<BookItem> findAll(){
        return bookItemMapper.selectList(null);
    }

    @Override
    public int delete(int book_id) {
        return bookItemMapper.delete(
                new LambdaQueryWrapper<BookItem>().eq(BookItem::getBook_id,book_id)
        );//下架书籍
    }
    //设置库存量为0，标记为缺货
    @Override
    public int updateStorage(BookItem bookItem) {
        return bookItemMapper.updateStorage(
                bookItem, new LambdaQueryWrapper<BookItem>().eq(BookItem::getBook_storage,bookItem.getBook_storage())
        );
    }

    @Override
    public int update(BookItem bookItem) {
        return bookItemMapper.update(
                bookItem, new LambdaQueryWrapper<BookItem>().eq(BookItem::getBook_id,bookItem.getBook_id())
        );//更改图书信息
    }

    @Override
    public BookItem getBookItemById(Integer id) {
        BookItem bookItem = bookItemMapper.selectOne(new LambdaQueryWrapper<BookItem>()
                .eq(BookItem::getBook_id,id));
        return bookItem;
    }//根据图书id获取当前图片信息

    /**
     * 根据书名获取书的相关信息
     * @param name
     * @return
     */
    @Override
    public List<BookItem> getBookIdByName(String name) {
        return bookItemMapper.selectList(new LambdaQueryWrapper<BookItem>().
                like(BookItem::getBook_name, name));
    }//根据图书name返回相关的信息

    @Override
    public List<BookItem> getBookByStatus(String typeName) {

        List<BookItem> list = bookItemMapper.selectList(null);
        List<BookItem> collect = list.stream().filter(e -> {
            if (e.getType_name().equals(typeName)) {
                return true;
            }else {
                return false;
            }
        }).collect(Collectors.toList());
return collect;
    }

    @Override
    public List<BookItem> getBookOrderByDate() {
        Page<BookItem> page = bookItemMapper.selectPage(new Page<BookItem>(1, 6),
                new LambdaQueryWrapper<BookItem>()
                        .orderByDesc(BookItem::getCreate_time));
            return page.getRecords();
    }

}//根据type_name返回与其对应的type_id以及对应的图书相关信息
