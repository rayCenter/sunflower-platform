package com.center.view.common.extract;

import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;

import java.util.List;

public interface IAbstractService<Qo, Vo> {

    ResponseResult<ApiPageableResult<List<Vo>>> findPageable(final Qo qo);

    void add(final Vo vo);

    void deleteByIds(final String... ids);

    void edit(final Vo vo);

    Vo findById(final String id);
}
