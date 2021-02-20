package com.center.view.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 一、自定义存储库基类接口
 * 1.启动时不初始化该接口；
 * 2.继承Repository（不公开CRUD方法）；
 * 3.如使用类似Hibernated的Criteria的查询方式；（使用的它的原因是：在执行分页排序的查询时，可以附加查询条件，增加了灵活性。），继承JpaSpecificationExecutor，实现一组JPA Criteria查询相关的方法；
 *
 * @param <T>  动态代理实体类
 * @param <ID> 动态代理实体类主键ID
 * @author 向晚门楣
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
