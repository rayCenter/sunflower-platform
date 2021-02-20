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
@javax.persistence.Table(name = "sys_menu_po")
@Table(appliesTo = "sys_menu_po", comment = "系统菜单表")
public class SysMenuPo extends AbstractPo implements Serializable {

    @Column(name = "code", nullable = false, columnDefinition = "varchar(100) comment '菜单号'")
    private String code;

    @Column(name = "p_code", nullable = false, columnDefinition = "varchar(100) comment '父菜单号'")
    private String pCode;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) comment '菜单名称'")
    private String name;

    @Column(name = "path", nullable = false, columnDefinition = "varchar(100) comment '菜单路径'")
    private String path;

    @Column(name = "icon", nullable = false, columnDefinition = "varchar(100) comment '菜单图标'")
    private String icon;

    @Column(name = "serial_number", nullable = false, columnDefinition = "tinyint comment '菜单序号'")
    private int serialNumber;
}
