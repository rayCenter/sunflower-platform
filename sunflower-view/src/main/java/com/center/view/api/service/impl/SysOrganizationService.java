package com.center.view.api.service.impl;

import com.center.common.ConstantEnum;
import com.center.common.error.AssertUtils;
import com.center.common.error.BusinessException;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.common.mapper.IBeanConverter;
import com.center.view.api.po.SysOrganizationPo;
import com.center.view.api.qo.SysOrganizationQo;
import com.center.view.api.repository.ISysOrganizationRepository;
import com.center.view.api.service.ISysOrganizationService;
import com.center.view.api.vo.SysOrganizationVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SysOrganizationService implements ISysOrganizationService {

    private final IBeanConverter iBeanConverter;

    private final ISysOrganizationRepository iSysOrganizationRepository;

    SysOrganizationService(IBeanConverter iBeanConverter, ISysOrganizationRepository iSysOrganizationRepository) {
        this.iBeanConverter = iBeanConverter;
        this.iSysOrganizationRepository = iSysOrganizationRepository;
    }

    @Override
    public ResponseResult<ApiPageableResult<List<SysOrganizationVo>>> findPageable(SysOrganizationQo qo) {
        Page<SysOrganizationPo> sysOrganizationPos = iSysOrganizationRepository.findAll(PageRequest.of(qo.getStartPage(), qo.getPageSize(), Sort.Direction.DESC, "modifyTime"));
        List<SysOrganizationVo> sysOrganizationVos = iBeanConverter.convert(sysOrganizationPos, SysOrganizationVo.class);
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询分页列表成功",
                ApiPageableResult.succeeded(
                        sysOrganizationPos.getTotalElements(),
                        sysOrganizationVos
                )
        );
    }

    @Override
    public void add(SysOrganizationVo vo) {
        AssertUtils.isNotBlank(vo.getId(), "无法新增");
        SysOrganizationPo sysOrganizationPo = iBeanConverter.convert(vo, SysOrganizationPo.class);
        iSysOrganizationRepository.save(sysOrganizationPo);
    }

    @Override
    public void deleteByIds(String... ids) {
        for (String id : ids) {
            Optional<SysOrganizationPo> optionalSysOrganizationPo = iSysOrganizationRepository.findById(id);
            if (optionalSysOrganizationPo.isPresent()) {
                iSysOrganizationRepository.deleteById(id);
            }
        }
    }

    @Override
    public void edit(SysOrganizationVo vo) {
        AssertUtils.isBlank(vo.getId(), "无法编辑");
        SysOrganizationPo sysOrganizationPo = iBeanConverter.convert(vo, SysOrganizationPo.class);
        iSysOrganizationRepository.save(sysOrganizationPo);
    }

    @Override
    public SysOrganizationVo findById(String id) {
        Optional<SysOrganizationPo> optionalSysOrganizationPo = iSysOrganizationRepository.findById(id);
        if (optionalSysOrganizationPo.isPresent()) {
            return iBeanConverter.convert(optionalSysOrganizationPo.get(), SysOrganizationVo.class);
        }
        throw new BusinessException(String.format("根据[%s]查询空", id));
    }
}
