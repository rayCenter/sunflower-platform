package com.center.view.common.extract;

import com.center.common.http.response.ResponseResult;
import com.center.common.http.response.impl.ApiPageableResult;

import java.util.List;

public abstract class AbstractController<Qo, Vo> {

    public abstract ResponseResult<ApiPageableResult<List<Vo>>> list(final Qo qo);

    public abstract ResponseResult<String> add(final Vo vo);

    public abstract ResponseResult<String> delete(final String... ids);

    public abstract ResponseResult<String> edit(final Vo vo);

    public abstract ResponseResult<Vo> detail(final String id);
}
