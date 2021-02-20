package com.center.view.api.service.impl;

import com.center.common.ConstantEnum;
import com.center.common.error.AssertUtils;
import com.center.common.error.BusinessException;
import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;
import com.center.common.http.response.impl.ApiResult;
import com.center.common.mapper.IBeanConverter;
import com.center.view.api.po.SysUserPo;
import com.center.view.api.qo.SysUserQo;
import com.center.view.api.repository.ISysUserRepository;
import com.center.view.api.service.ISysUserService;
import com.center.view.api.vo.SysUserVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Optional;

@Service
public class SysUserService implements ISysUserService {

    private final IBeanConverter iBeanConverter;

    private final ISysUserRepository iSysUserRepository;

    SysUserService(IBeanConverter iBeanConverter, ISysUserRepository iSysUserRepository) {
        this.iBeanConverter = iBeanConverter;
        this.iSysUserRepository = iSysUserRepository;
    }

    @Override
    public ResponseResult<ApiPageableResult<List<SysUserVo>>> findPageable(SysUserQo qo) {
        Specification<SysUserPo> specification = (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (StringUtils.isNotBlank(qo.getUsername())) {
                predicate.getExpressions().add(criteriaBuilder.like(root.get("username"), "%" + qo.getUsername() + "%"));
            }
            return predicate;
        };
        Page<SysUserPo> sysUserPos = iSysUserRepository.findAll(specification, PageRequest.of(qo.getStartPage(), qo.getPageSize(), Sort.Direction.DESC, "modifyTime"));
        List<SysUserVo> sysUserVos = iBeanConverter.convert(sysUserPos, SysUserVo.class);
        return ApiResult.succeeded(
                ConstantEnum.Status.SUCCEEDED.getCode(),
                "查询分页列表成功",
                ApiPageableResult.succeeded(
                        sysUserPos.getTotalElements(),
                        sysUserVos
                )
        );
    }

    @Override
    public void add(SysUserVo vo) {
        AssertUtils.isNotBlank(vo.getId(), "无法新增");
        SysUserPo sysUserPo = iBeanConverter.convert(vo, SysUserPo.class);
        iSysUserRepository.save(sysUserPo);
    }

    @Override
    public void deleteByIds(String... ids) {
        for (String id : ids) {
            Optional<SysUserPo> optionalSysUserPo = iSysUserRepository.findById(id);
            if (optionalSysUserPo.isPresent()) {
                iSysUserRepository.deleteById(id);
            }
        }
    }

    @Override
    public void edit(SysUserVo vo) {
        AssertUtils.isBlank(vo.getId(), "无法编辑");
        SysUserPo sysUserPo = iBeanConverter.convert(vo, SysUserPo.class);
        iSysUserRepository.save(sysUserPo);
    }

    @Override
    public SysUserVo findById(String id) {
        Optional<SysUserPo> optionalSysUserPo = iSysUserRepository.findById(id);
        if (optionalSysUserPo.isPresent()) {
            return iBeanConverter.convert(optionalSysUserPo.get(), SysUserVo.class);
        }
        throw new BusinessException(String.format("根据[%s]查询空", id));
    }
}
