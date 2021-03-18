package com.center.view.api.controller;

import com.alibaba.fastjson.JSON;
import com.center.common.ConstantEnum;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.view.api.qo.SysUserQo;
import com.center.view.api.service.ISysUserService;
import com.center.view.api.vo.SysUserVo;
import com.center.view.common.extract.AbstractController;
import com.center.view.common.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(
        name = "系统用户api",
        path = "/sys_user",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SysUserController extends AbstractController<SysUserQo, SysUserVo> {

    private final ISysUserService iSysUserService;

    SysUserController(final ISysUserService iSysUserService) {
        this.iSysUserService = iSysUserService;
    }

    @PostMapping(
            name = "列表",
            path = {"/list.json", "/list.do"}
    )
    @Override
    public ResponseResult<ApiPageableResult<List<SysUserVo>>> list(final @RequestBody SysUserQo qo) {
        return iSysUserService.findPageable(qo);
    }

    @PostMapping(
            name = "新增",
            path = {"/add.json", "/add.do"}
    )
    @Override
    public ResponseResult<String> add(final @RequestBody SysUserVo vo) {
        iSysUserService.add(vo);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "新增成功");
    }

    @GetMapping(
            name = "删除",
            path = {"/delete.json", "/delete.do"}
    )
    @Override
    public ResponseResult<String> delete(final @RequestBody String... ids) {
        iSysUserService.deleteByIds(ids);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "删除成功");
    }

    @PostMapping(
            name = "编辑",
            path = {"/edit.json", "/edit.do"}
    )
    @Override
    public ResponseResult<String> edit(final @RequestBody SysUserVo vo) {
        iSysUserService.edit(vo);
        return ApiResult.succeeded(ConstantEnum.Status.SUCCEEDED.getCode(), "编辑成功");
    }

    @GetMapping(
            name = "查询",
            path = {"/edit.json", "/edit.do"}
    )
    @Override
    public ResponseResult<SysUserVo> detail(final @RequestParam("id") String id) {
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询成功",
                iSysUserService.findById(id));
    }

    @PostMapping(
            name = "系统登录入口",
            path = {"/login.json", "/login.do"}
    )
    public ResponseResult<String> login(final @RequestBody @Validated SysUserVo sysUserVo,
                                        final HttpServletRequest request,
                                        final HttpServletResponse response) {
        String authorization = request.getHeader(ConstantEnum.Login.AUTHORIZATION.getName());
        log.info("{}：{}", ConstantEnum.Login.AUTHORIZATION.getName(), authorization);
        response.setHeader(ConstantEnum.Login.AUTHORIZATION.getName(), JwtUtils.createJwt(JSON.toJSONString(sysUserVo)));
        String menus = "[{\"id\":\"0\",\"name\":\"主页\",\"path\":\"/main.html\",\"icon\":\"fa fa-fw fa-home\"},{\"id\":\"1\",\"name\":\"系统配置\",\"path\":\"#\",\"icon\":\"fa fa-fw fa-cogs\",\"menus\":[{\"id\":\"1-0\",\"name\":\"功能管理\",\"path\":\"/func/list.html\"},{\"id\":\"1-1\",\"name\":\"运行参数管理\",\"path\":\"/run_param/list.html\"},{\"id\":\"1-2\",\"name\":\"日志管理\",\"path\":\"/log/list.html\"},{\"id\":\"1-3\",\"name\":\"用户管理\",\"path\":\"/user/list.html\"},{\"id\":\"1-4\",\"name\":\"用户密码管理\",\"path\":\"/user/password/list.html\"},{\"id\":\"1-5\",\"name\":\"组织管理\",\"path\":\"/organization/list.html\"},{\"id\":\"1-6\",\"name\":\"角色管理\",\"path\":\"/role/list.html\"}]}]";
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "登录成功",
                menus
        );
    }

    @RequestMapping(
            method = {RequestMethod.GET, RequestMethod.POST},
            name = "例子",
            path = {"/example.json", "/example.do"}
    )
    public ResponseResult<List<Map<String, String>>> example() {
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "例子",
                new ArrayList<Map<String, String>>() {{
                    add(
                            new HashMap<String, String>() {{
                                put("key", "val");
                            }}
                    );
                }}
        );
    }
}