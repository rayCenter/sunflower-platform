package com.center.view.api.service.impl;

import com.center.common.ConstantEnum;
import com.center.common.error.AssertUtils;
import com.center.common.error.BusinessException;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.common.mapper.IBeanConverter;
import com.center.view.api.po.SysMenuPo;
import com.center.view.api.qo.SysMenuQo;
import com.center.view.api.repository.ISysMenuRepository;
import com.center.view.api.service.ISysMenuService;
import com.center.view.api.vo.SysMenuVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysMenuService implements ISysMenuService {

    private final IBeanConverter iBeanConverter;

    private final ISysMenuRepository iSysMenuRepository;

    SysMenuService(IBeanConverter iBeanConverter, ISysMenuRepository iSysMenuRepository) {
        this.iBeanConverter = iBeanConverter;
        this.iSysMenuRepository = iSysMenuRepository;
    }

    @Override
    public ResponseResult<ApiPageableResult<List<SysMenuVo>>> findPageable(SysMenuQo qo) {
        Page<SysMenuPo> sysMenuPos = iSysMenuRepository.findAll(PageRequest.of(qo.getStartPage(), qo.getPageSize(), Sort.Direction.DESC, "modifyTime"));
        List<SysMenuVo> sysMenuVos = iBeanConverter.convert(sysMenuPos, SysMenuVo.class);
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询分页列表成功",
                ApiPageableResult.succeeded(
                        sysMenuPos.getTotalElements(),
                        sysMenuVos
                )
        );
    }

    @Override
    public void add(SysMenuVo vo) {
        AssertUtils.isNotBlank(vo.getId(), "无法新增");
        SysMenuPo sysMenuPo = iBeanConverter.convert(vo, SysMenuPo.class);
        iSysMenuRepository.save(sysMenuPo);
    }

    @Override
    public void deleteByIds(String... ids) {
        for (String id : ids) {
            Optional<SysMenuPo> optionalSysMenuPo = iSysMenuRepository.findById(id);
            if (optionalSysMenuPo.isPresent()) {
                iSysMenuRepository.deleteById(id);
            }
        }
    }

    @Override
    public void edit(SysMenuVo vo) {
        AssertUtils.isBlank(vo.getId(), "无法编辑");
        SysMenuPo sysMenuPo = iBeanConverter.convert(vo, SysMenuPo.class);
        iSysMenuRepository.save(sysMenuPo);

    }

    @Override
    public SysMenuVo findById(String id) {
        Optional<SysMenuPo> optionalSysMenuPo = iSysMenuRepository.findById(id);
        if (optionalSysMenuPo.isPresent()) {
            return iBeanConverter.convert(optionalSysMenuPo.get(), SysMenuVo.class);
        }
        throw new BusinessException(String.format("根据[%s]查询空", id));
    }

}
