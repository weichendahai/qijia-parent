package com.qijia.framework.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.qijia.framework.dao.IBaseDao;
import com.qijia.framework.dao.MyEntityWrapper;
import com.qijia.framework.dao.MyPage;
import com.qijia.framework.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 抽象实现Server Dao 的方法
 * Created by weichen on 2018/9/27.
 */
public abstract class BaseServiceImpl<M extends IBaseDao<T>, T> implements IBaseService<T> {

//	private static final String ID = "id";

	@Autowired
	protected M baseDao;

	@Override
	public Integer insert(T var1) {
		return baseDao.insert(var1);
	}

	@Override
	public Integer insertAllColumn(T var1) {
		return baseDao.insertAllColumn(var1);
	}

	@Override
	public Integer deleteById(Serializable var1) {
		return baseDao.deleteById(var1);
	}

	@Override
	public Integer deleteByMap(Map<String, Object> var1) {
		return baseDao.deleteByMap(var1);
	}

	@Override
	public Integer delete(MyEntityWrapper<T> var1) {
		return baseDao.delete(var1);
	}

	@Override
	public Integer deleteBatchIds(Collection<? extends Serializable> var1) {
		return baseDao.deleteBatchIds(var1);
	}

	@Override
	public Integer updateById(T var1) {
		return baseDao.updateById(var1);
	}

	@Override
	public Integer updateAllColumnById(T var1) {
		return baseDao.updateAllColumnById(var1);
	}

	@Override
	public Integer update(T var1, MyEntityWrapper<T> var2) {
		return baseDao.update(var1, var2);
	}

	@Override
	public T selectById(Serializable var1) {
		return baseDao.selectById(var1);
	}

	@Override
	public List<T> selectBatchIds(Collection<? extends Serializable> var1) {
		return baseDao.selectBatchIds(var1);
	}

	@Override
	public List<T> selectByMap(Map<String, Object> var1) {
		return baseDao.selectByMap(var1);
	}

	@Override
	public T selectOne(T var1) {
		return baseDao.selectOne(var1);
	}

	@Override
	public Integer selectCount(MyEntityWrapper<T> var1) {
		return baseDao.selectCount(var1);
	}

	@Override
	public List<T> selectList(MyEntityWrapper<T> var1) {
		return baseDao.selectList(var1);
	}

	@Override
	public MyPage<T> selectPage(MyPage<T> page) {
		return this.selectPage(page, new MyEntityWrapper());
	}

	@Override
	public List<Map<String, Object>> selectMaps(MyEntityWrapper<T> var1) {
		return baseDao.selectMaps(var1);
	}

	@Override
	public List<Object> selectObjs(MyEntityWrapper<T> var1) {
		return baseDao.selectObjs(var1);
	}

	@Override
	public MyPage<Map<String, Object>> selectMapsPage(MyPage page, MyEntityWrapper<T> wrapper) {
		wrapper = (MyEntityWrapper<T>) fillWrapper(page, wrapper);
		page.setRecords(this.baseDao.selectMapsPage(page, wrapper));
		return page;
	}

	@Override
	public MyPage<T> selectPage(MyPage<T> page, MyEntityWrapper<T> wrapper) {
//		wrapper = SqlHelper.fillWrapper(page, wrapper);
//		page.setRecords(this.baseDao.selectPage(page, wrapper));
//		return page;

		wrapper = (MyEntityWrapper<T>) fillWrapper(page, wrapper);
		page.setRecords(this.baseDao.selectPage(page, wrapper));
		return page;
	}

	public static MyEntityWrapper<?> fillWrapper(MyPage<?> page, MyEntityWrapper<?> wrapper) {
		if (null == page) {
			return wrapper;
		} else {
			if (isEmptyOfWrapper(wrapper)) {
//				wrapper = Condition.create();
				wrapper = new MyEntityWrapper<>();
			}

			if (page.isOpenSort() && page.isSearchCount()) {
				((MyEntityWrapper) wrapper).orderAsc(page.getAscs());
				((MyEntityWrapper) wrapper).orderDesc(page.getDescs());
			}

			if (isNotEmpty(page.getCondition())) {
				((MyEntityWrapper) wrapper).allEq(page.getCondition());
			}

			return wrapper;
		}
	}

	public static boolean isEmptyOfWrapper(MyEntityWrapper<?> wrapper) {
		return null == wrapper || Condition.EMPTY == wrapper;
	}

	public static boolean isNotEmptyOfWrapper(MyEntityWrapper<?> wrapper) {
		return !isEmptyOfWrapper(wrapper);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return map == null || map.isEmpty();
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}
}
