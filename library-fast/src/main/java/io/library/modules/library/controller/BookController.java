package io.library.modules.library.controller;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import io.library.modules.sys.controller.AbstractController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.library.modules.library.entity.BookEntity;
import io.library.modules.library.service.BookService;
import io.library.common.utils.PageUtils;
import io.library.common.utils.R;



/**
 * 图书信息
 *
 * @author xushifu
 * @email sunlightcs@gmail.com
 * @date 2021-03-10 10:04:46
 */
@RestController
@RequestMapping("library/book")
public class BookController extends AbstractController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("library:book:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bookService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bookId}")
    @RequiresPermissions("library:book:info")
    public R info(@PathVariable("bookId") Long bookId){
		BookEntity book = bookService.getById(bookId);

        return R.ok().put("book", book);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("library:book:save")
    public R save(@RequestBody BookEntity book){
        book.setCreateUserId(getUser().getUserId());
        book.setCreateUserName(getUser().getUsername());
        book.setCreateTime(new Date());
		bookService.save(book);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("library:book:update")
    public R update(@RequestBody BookEntity book){
		bookService.updateById(book);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("library:book:delete")
    public R delete(@RequestBody Long[] bookIds){
		bookService.removeByIds(Arrays.asList(bookIds));

        return R.ok();
    }

}
