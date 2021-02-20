package com.center.view.api.po;

import com.center.view.common.extract.AbstractPo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@javax.persistence.Table(name = "sys_user_po")
@Table(appliesTo = "sys_user_po", comment = "系统用户表")
public class SysUserPo extends AbstractPo implements Serializable {

    @Column(name = "username", nullable = false, columnDefinition = "varchar(100) comment '用户登录名'")
    private String username;

    @Column(name = "password", nullable = false, columnDefinition = "varchar(100) comment '用户密码'")
    private String password;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) comment '用户姓名'")
    private String name;

    @Column(name = "email", nullable = false, columnDefinition = "varchar(100) comment '用户电子邮件'")
    private String email;

    @Column(name = "phone", nullable = false, columnDefinition = "varchar(100) comment '用户手机号码'")
    private String phone;
}
