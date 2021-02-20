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
@javax.persistence.Table(name = "sys_organization_po")
@Table(appliesTo = "sys_organization_po", comment = "系统组织表")
public class SysOrganizationPo extends AbstractPo implements Serializable {

    @Column(name = "code", columnDefinition = "varchar(100) comment '组织号'")
    private String code;

    @Column(name = "p_code", columnDefinition = "varchar(100) comment '父组织号'")
    private String pCode;

    @Column(name = "name", columnDefinition = "varchar(100) comment '组织名称'")
    private String name;

    @Column(name = "serial_number", columnDefinition = "int comment '组织序号'")
    private int serialNumber;
}
