package io.library.modules.library.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.library.common.utils.PageUtils;
import io.library.modules.library.entity.BookEntity;

import java.util.Map;

/**
 * 书信息
 *
 * @authorxushifu
 * @email sunlightcs@gmail.com
 * @date 2021-03-10 10:04:46
 */
public interface BookService extends IService<BookEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

