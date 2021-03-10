/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.library.io
 *
 * 版权所有，侵权必究！
 */

package io.library.modules.oss.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.library.modules.oss.entity.SysOssEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface SysOssDao extends BaseMapper<SysOssEntity> {
	
}
