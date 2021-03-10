/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.library.io
 *
 * 版权所有，侵权必究！
 */

package io.library.modules.sys.form;

import lombok.Data;

/**
 * 密码表单
 *
 * @author Mark sunlightcs@gmail.com
 */
@Data
public class PasswordForm {
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;

}