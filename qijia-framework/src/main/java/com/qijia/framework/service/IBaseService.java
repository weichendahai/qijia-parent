package com.qijia.framework.service;

/**
 * 基础 service 接口层
 * Created by weichen on 2018/9/27.
 */

import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.framework.dao.MyPage;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IBaseService<T> {

	Integer insert(T var1);

	Integer insertAllColumn(T var1);

	Integer deleteById(Serializable var1);

	Integer deleteByMap(Map<String, Object> var1);

	Integer delete(MyEntityWrapper<T> var1);

	Integer deleteBatchIds( Collection<? extends Serializable> var1);

	Integer updateById( T var1);

	Integer updateAllColumnById( T var1);

	Integer update( T var1,  MyEntityWrapper<T> var2);

	T selectById(Serializable var1);

	List<T> selectBatchIds( Collection<? extends Serializable> var1);

	List<T> selectByMap( Map<String, Object> var1);

	T selectOne( T var1);

	Integer selectCount(MyEntityWrapper<T> var1);

	List<T> selectList(MyEntityWrapper<T> var1);

	MyPage<T> selectPage(MyPage<T> var1);

	List<Map<String, Object>> selectMaps(MyEntityWrapper<T> var1);

	List<Object> selectObjs(MyEntityWrapper<T> var1);

	MyPage<Map<String, Object>> selectMapsPage(MyPage var1, MyEntityWrapper<T> var2);

	MyPage<T> selectPage(MyPage<T> var1, MyEntityWrapper<T> var2);
}