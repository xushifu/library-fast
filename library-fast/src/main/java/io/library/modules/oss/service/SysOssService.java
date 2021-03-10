/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.library.io
 *
 * 版权所有，侵权必究！
 */

package io.library.modules.oss.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.library.common.utils.PageUtils;
import io.library.modules.oss.entity.SysOssEntity;

import java.util.Map;

/**
 * 文件上传
 *
 * @author Mark sunlightcs@gmail.com
 */
public interface SysOssService extends IService<SysOssEntity> {

	PageUtils queryPage(Map<String, Object> params);
}
