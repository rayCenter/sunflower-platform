package com.center.view.api.repository;

import com.center.view.api.po.SysRolePo;
import com.center.view.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysRoleRepository extends BaseRepository<SysRolePo, String> {
}
