##BookStoreApp-Backend【主要是针对管理员端（web端）和用户端（小程序端）的相关数据库操作和一些接口的设计和编写】
#主要实用技术有：SpringBoot + Mybatis_plus + MySQL，下面是一些接口的编写：
* 图书相关接口：
```Java
//添加图书数据（管理员端）
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
    * 用户收藏/取消收藏接口
    ```java
     // 收藏接口
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
