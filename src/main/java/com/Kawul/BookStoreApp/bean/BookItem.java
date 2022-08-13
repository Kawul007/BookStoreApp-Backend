package com.Kawul.BookStoreApp.bean;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer book_id;//书唯一id
    private String book_name;//书籍名称
    private String book_info;//书籍简介
    private String type_name;//书籍类型
    private String book_writer;//作者
    private Float book_price;//价格
    private Integer book_storage;//库存量
    private String book_img;//图书海报
    private Integer type_id;//类别id
    private Date create_time;//上传时间


}
