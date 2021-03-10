package io.library.modules.library.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.library.common.utils.PageUtils;
import io.library.common.utils.Query;

import io.library.modules.library.dao.BookDao;
import io.library.modules.library.entity.BookEntity;
import io.library.modules.library.service.BookService;


@Service("bookService")
public class BookServiceImpl extends ServiceImpl<BookDao, BookEntity> implements BookService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        QueryWrapper wrappers = new QueryWrapper<BookEntity>();
        if(StringUtils.isNotBlank(params.get("key").toString()))
        {
            wrappers.like("bookname",params.get("key").toString());

            wrappers.or();

            wrappers.like("brief",params.get("key").toString());

        }

        IPage<BookEntity> page = this.page(
                new Query<BookEntity>().getPage(params),
                wrappers
        );

        return new PageUtils(page);
    }

}