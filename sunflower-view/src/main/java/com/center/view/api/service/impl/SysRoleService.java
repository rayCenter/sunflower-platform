package com.center.view.api.service.impl;

import com.center.common.ConstantEnum;
import com.center.common.error.AssertUtils;
import com.center.common.error.BusinessException;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.common.mapper.IBeanConverter;
import com.center.view.api.po.SysRolePo;
import com.center.view.api.qo.SysRoleQo;
import com.center.view.api.repository.ISysRoleRepository;
import com.center.view.api.service.ISysRoleService;
import com.center.view.api.vo.SysRoleVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysRoleService implements ISysRoleService {

    private final IBeanConverter iBeanConverter;

    private final ISysRoleRepository iSysRoleRepository;

    SysRoleService(IBeanConverter iBeanConverter, ISysRoleRepository iSysRoleRepository) {
        this.iBeanConverter = iBeanConverter;
        this.iSysRoleRepository = iSysRoleRepository;
    }


    @Override
    public ResponseResult<ApiPageableResult<List<SysRoleVo>>> findPageable(SysRoleQo qo) {
        Page<SysRolePo> sysRolePos = iSysRoleRepository.findAll(PageRequest.of(qo.getStartPage(), qo.getPageSize(), Sort.Direction.DESC, "modifyTime"));
        List<SysRoleVo> sysRoleVos = iBeanConverter.convert(sysRolePos, SysRoleVo.class);
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询分页列表成功",
                ApiPageableResult.succeeded(
                        sysRolePos.getTotalElements(),
                        sysRoleVos
                )
        );
    }

    @Override
    public void add(SysRoleVo vo) {
        AssertUtils.isNotBlank(vo.getId(), "无法新增");
        SysRolePo sysRolePo = iBeanConverter.convert(vo, SysRolePo.class);
        iSysRoleRepository.save(sysRolePo);
    }

    @Override
    public void deleteByIds(String... ids) {
        for (String id : ids) {
            Optional<SysRolePo> optionalSysRolePo = iSysRoleRepository.findById(id);
            if (optionalSysRolePo.isPresent()) {
                iSysRoleRepository.deleteById(id);
            }
        }
    }

    @Override
    public void edit(SysRoleVo vo) {
        AssertUtils.isBlank(vo.getId(), "无法编辑");
        SysRolePo sysRolePo = iBeanConverter.convert(vo, SysRolePo.class);
        iSysRoleRepository.save(sysRolePo);
    }

    @Override
    public SysRoleVo findById(String id) {
        Optional<SysRolePo> optionalSysRolePo = iSysRoleRepository.findById(id);
        if (optionalSysRolePo.isPresent()) {
            return iBeanConverter.convert(optionalSysRolePo.get(), SysRoleVo.class);
        }
        throw new BusinessException(String.format("根据[%s]查询空", id));
    }
}
