package com.center.common.mapper;

import ma.glasnost.orika.MapperFactory;

import java.util.List;

public interface IBeanConverter {

    MapperFactory getBeanMapperFactory();

    <A, B> B convert(A clazzVo, Class<B> clazz);

    <A, B> List<B> convert(Iterable<A> clazzVos, Class<B> clazz);

}
