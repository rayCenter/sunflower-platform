package com.center.view.api.vo;

import com.center.view.common.extract.AbstractVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysOrganizationVo extends AbstractVo implements Serializable {

    private String code;

    private String pCode;

    private String name;

    private int serialNumber;
}
