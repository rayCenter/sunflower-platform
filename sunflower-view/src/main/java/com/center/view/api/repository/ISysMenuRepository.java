package com.center.view.api.repository;

import com.center.view.api.po.SysMenuPo;
import com.center.view.core.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISysMenuRepository extends BaseRepository<SysMenuPo, String> {
}
