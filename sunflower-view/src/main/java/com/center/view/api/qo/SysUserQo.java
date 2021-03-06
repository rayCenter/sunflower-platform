package com.center.view.api.qo;

import com.center.common.http.request.ApiPageable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserQo extends ApiPageable {

    private String username;
}
