package com.Kawul.BookStoreApp;

import com.Kawul.BookStoreApp.bean.BookItem;
import com.Kawul.BookStoreApp.dao.BookItemMapper;
import com.Kawul.BookStoreApp.service.BookItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookStoreAppApplicationTests {
@Autowired
private BookItemMapper bookItemMapper;

	@Autowired
	private BookItemService bookItemService;

	@Test
	void contextLoads() {
		List<BookItem> list = bookItemService.getBookIdByName("你");
		System.out.println("list = " + list);
//		BookItem bookItemById = bookItemService.getBookItemById(18);
//		System.out.println("bookItemById = " + bookItemById);
	}

//	http://localhost:8080/book43.jpg
	@Test
	public void updateImg(){
//		List<BookItem> list = bookItemMapper.selectList(null);
//		list.stream().map(e->{
//			String bookImg = e.getBook_img();
//			int start = bookImg.indexOf("//");
//			bookImg.lastIndexOf(":");
//
//		});
		StringBuilder builder = new StringBuilder();
		builder.append("http://");
		String str=  "http://localhost:8080/book43.jpg";
		int start = str.lastIndexOf("//");
		int end = str.lastIndexOf(":");
		String substring = str.substring(start+2, end);
		System.out.println("substring = " + substring);

		builder.append(":8080");
		String substring1 = str.substring(str.lastIndexOf("/"));
		System.out.println("substring1 = " + substring1);
	}

}
