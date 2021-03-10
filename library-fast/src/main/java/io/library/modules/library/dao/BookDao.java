package io.library.modules.library.dao;

import io.library.modules.library.entity.BookEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 书信息
 * 
 * @authorxushifu
 * @email sunlightcs@gmail.com
 * @date 2021-03-10 10:04:46
 */
@Mapper
public interface BookDao extends BaseMapper<BookEntity> {
	
}
