package com.center.view.api.repository;

import com.center.view.api.po.SysUserPo;
import com.center.view.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysUserRepository extends BaseRepository<SysUserPo, String> {
}
