package com.center.view.api.vo;

import com.center.view.common.extract.AbstractVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserVo extends AbstractVo implements Serializable {

    @NotBlank(message = "用户名，不能为空")
    private String username;

    @NotBlank(message = "密码，不能为空")
    private String password;

    private String name;

    private String email;

    private String phone;
}
