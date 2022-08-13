package com.Kawul.BookStoreApp.controller;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.Kawul.BookStoreApp.common.Response;
import com.Kawul.BookStoreApp.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection")
@CrossOrigin
public class CollectionController {


    @Autowired
    private CollectionService collectionService;

    /**
     * 收藏接口
     * @param bookId
     * @param userId
     * @return
     */
    @GetMapping("/assign/{bookId}/{userId}")
    public Response assignBook(@PathVariable("bookId") Integer bookId,
                               @PathVariable("userId") Integer userId
                        ){
                 Boolean flag =   collectionService.assignBook(bookId,userId);
    return flag? Response.success("成功"): Response.error();
    }

    /**
     * 根据用户id获取收藏的书本
     * @param userId
     * @return
     */
    @GetMapping("/getCollectionBook/{userId}")
    public Response getCollectionBook(
                        @PathVariable("userId") Integer userId
    ){
//                TODO 因为没做登录，所以不用threadlocal的方式及逆行用户信息的获取，直接前端传死用户id
        List<BookItem> list=collectionService.getCollectionBook(userId);
        return Response.success("成功",list);
    }

    /**
     * 取消收藏
     * @param bookId
     * @param userId
     * @return
     */
    @GetMapping("/cancel/{bookId}/{userId}")
    public Response cancleCollection(@PathVariable("bookId") Integer bookId,
                                     @PathVariable("userId") Integer userId
    ){
        Boolean flag =   collectionService.cancleCollection(bookId,userId);
        return flag? Response.success("成功"): Response.error();
    }
//    @GetMapping
}
