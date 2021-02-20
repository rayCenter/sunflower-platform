package com.center.view.api.controller;

import com.center.common.ConstantEnum;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.view.api.qo.SysRoleQo;
import com.center.view.api.service.ISysRoleService;
import com.center.view.api.vo.SysRoleVo;
import com.center.view.common.extract.AbstractController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(
        name = "系统角色api",
        path = "/sys_role",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SysRoleController extends AbstractController<SysRoleQo, SysRoleVo> {

    private final ISysRoleService iSysRoleService;

    SysRoleController(final ISysRoleService iSysRoleService) {
        this.iSysRoleService = iSysRoleService;
    }

    @PostMapping(
            name = "列表",
            path = "/list.json"
    )
    @Override
    public ResponseResult<ApiPageableResult<List<SysRoleVo>>> list(SysRoleQo qo) {
        return iSysRoleService.findPageable(qo);
    }

    @PostMapping(
            name = "新增",
            path = "/add.json"
    )
    @Override
    public ResponseResult<String> add(SysRoleVo vo) {
        iSysRoleService.add(vo);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "新增成功");
    }

    @GetMapping(
            name = "删除",
            path = "/delete.json"
    )
    @Override
    public ResponseResult<String> delete(String... ids) {
        iSysRoleService.deleteByIds(ids);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "删除成功");
    }

    @PostMapping(
            name = "编辑",
            path = "/edit.json"
    )
    @Override
    public ResponseResult<String> edit(SysRoleVo vo) {
        iSysRoleService.edit(vo);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "编辑成功");
    }

    @GetMapping(
            name = "查询",
            path = "/edit.json"
    )
    @Override
    public ResponseResult<SysRoleVo> detail(String id) {
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询成功",
                iSysRoleService.findById(id));
    }
}
