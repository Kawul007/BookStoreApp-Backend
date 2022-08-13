package com.Kawul.BookStoreApp.controller;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.Kawul.BookStoreApp.common.Response;
import com.Kawul.BookStoreApp.service.BookItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/bookitem")
@CrossOrigin
public class BookItemController {
    @Autowired(required = false)
    private BookItemService bookItemService;

    //添加数据
    @PostMapping("/add")
    public String add(@RequestBody BookItem bookItem) {
        bookItemService.saveBookItem(bookItem);
        return "新数据已成功添加！！";
    }
    //根据book_id返回数据  用来详情页传值渲染
    @GetMapping("{id}")
    public BookItem getBookItemById(@PathVariable("id") Integer id) {
        return bookItemService.getBookItemById(id);
    }

    //获取数据【获取所有的】
    @GetMapping("/getAll")
    public List<BookItem> findAll() {
        return bookItemService.findAll();
    }

    //删除数据
    @RequestMapping("/delete/{book_id}")//
    public Response<?> delete(@PathVariable Integer book_id, HttpServletResponse servletResponse) throws IOException {
        int count = bookItemService.delete(book_id);
        if (count == 1) {
            //
            return Response.success("删除成功");
        }
        return Response.error("删除失败");
    }

    //更新数据
    @PostMapping("/update")
    public Response<?> update(@RequestBody BookItem bookItem) {
        int i = bookItemService.update(bookItem);
        System.out.println(bookItem);
        return i>0?Response.success("更新成功"):Response.error("更新失败");
    }

    //更新数据
    @PostMapping("/update/{book_storage}")
    public Response<?> updateStorage(@RequestBody BookItem bookItem) {
        int i = bookItemService.update(bookItem);
        System.out.println(bookItem);
        return i>0?Response.success("更新成功"):Response.error("更新失败");
    }

    /**
     * 根据书名获取书的相关信息
     *
     * @param name
     * @return
     */
    //根据书名搜索
    @GetMapping("search/{name}")
    public Response<?> getBookIdByName(@PathVariable("name") String name) {
        log.info(name);
        List<BookItem> list = bookItemService.getBookIdByName(name);
        return Response.success("成功", list);
    }

    //根据typename来过滤
    @GetMapping("getBookByStatus/{typeName}")
    public Response<?> getBookByStatus(@PathVariable("typeName") String typeName) {
        List<BookItem> list = bookItemService.getBookByStatus(typeName);

        return Response.success("成功", list);
    }

    /**
     * 获取新品=>其实就是按照时间create_time来拉取最新六个图书信息
     * @return
     */
    @GetMapping("getBookOrderByDate")
    public Response<?> getBookOrderByDate(){
        List<BookItem> list = bookItemService.getBookOrderByDate();
        return Response.success("成功",list);
    }
}

