package com.center.view.api.repository;

import com.center.view.api.po.SysOrganizationPo;
import com.center.view.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysOrganizationRepository extends BaseRepository<SysOrganizationPo, String> {
}
