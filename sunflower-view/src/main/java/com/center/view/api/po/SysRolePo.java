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
@javax.persistence.Table(name = "sys_role_po")
@Table(appliesTo = "sys_role_po", comment = "系统角色表")
public class SysRolePo extends AbstractPo implements Serializable {

    @Column(name = "name", columnDefinition = "varchar(100) comment '角色名称'")
    private String name;
}
