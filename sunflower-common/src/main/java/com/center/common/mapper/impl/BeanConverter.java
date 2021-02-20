package com.center.common.mapper.impl;

import com.center.common.mapper.IBeanConverter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

public class BeanConverter implements IBeanConverter {

    private static MapperFacade MAPPER_FACADE;

    public BeanConverter() {
        MAPPER_FACADE = getBeanMapperFactory().getMapperFacade();
    }

    @Override
    public MapperFactory getBeanMapperFactory() {
        return new DefaultMapperFactory.Builder().build();
    }

    @Override
    public <A, B> B convert(A source, Class<B> target) {
        return MAPPER_FACADE.map(source, target);
    }

    @Override
    public <A, B> List<B> convert(Iterable<A> sources, Class<B> targets) {
        return MAPPER_FACADE.mapAsList(sources, targets);
    }

}
