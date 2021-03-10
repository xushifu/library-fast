package io.library.modules.library.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 书信息
 * 
 * @authorxushifu
 * @email sunlightcs@gmail.com
 * @date 2021-03-10 10:04:46
 */
@Data
@TableName("book")
public class BookEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long bookId;
	/**
	 * 图书名称
	 */
	private String bookname;
	/**
	 * ISBN码
	 */
	private String isbn;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 分类割
	 */
	private String classification;
	/**
	 * 译者
	 */
	private String translator;
	/**
	 * 图书单价
	 */
	private BigDecimal price;
	/**
	 * 藏书总量
	 */
	private Integer totalnumber;
	/**
	 * 馆内剩余
	 */
	private Integer leftnumber;
	/**
	 * 出版社
	 */
	private String publishername;
	/**
	 * 页数
	 */
	private Integer pages;
	/**
	 * 字数
	 */
	private Integer words;
	/**
	 * 存放位置
	 */
	private String locationname;
	/**
	 * 版次
	 */
	private Integer edition;
	/**
	 * 简介
	 */
	private String brief;
	/**
	 * 语言
	 */
	private Integer language;
	/**
	 * 创建者ID
	 */
	private Long createUserId;
	/**
	 * 创建者名字
	 */
	private String createUserName;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
