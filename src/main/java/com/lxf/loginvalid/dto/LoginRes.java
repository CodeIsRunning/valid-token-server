package com.lxf.loginvalid.dto;

import lombok.Data;

/**
 * @author liuxf
 * @version 1.0
 * @date 2020/6/17 16:22
 */
@Data
public class LoginRes {

    private Integer id;

    private String userName;

    private String phone;

    private String token;

}
