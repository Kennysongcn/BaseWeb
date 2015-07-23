package com.kenny.app.provider.common.bao;

import java.util.List;

import com.kenny.app.provider.common.util.Pager;
/**
 * 公共dao
 * @author kennysong
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 新增对象
	 * @param str
	 * @param entity
	 * @return
	 */
	public int save(String str,T entity)throws Exception;
	/**
	 * 修改对象
	 * @param str
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public Object update(String str,T entity)throws Exception;
	/**
	 * 批量新增
	 * @param str
	 * @param entitys
	 * @throws Exception
	 */
	public Object saveBatch(String str,List<T> entitys)throws Exception;
	/**
	 * 批量更新
	 * @param str
	 * @param entitys
	 * @throws Exception
	 */
	public void updateBatch(String str,List<T> entitys)throws Exception;
	/**
	 * 删除对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object delete(String str, T entity) throws Exception;
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForObject(String str, Object obj)  throws Exception;
	

	/**
	 * 查找对象 封装成List
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public List<T> findForList(String str, Object obj) throws Exception;
	
	/**
	 * 查找对象封装成Map
	 * @param sql
	 * @param obj
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public Object findForMap(String sql, Object obj, String key , String value) throws Exception;
	
	/**
	 * 获取实体
	 * 
	 * @param entityClass
	 *            实体类
	 * @param entityId
	 *            实体id
	 * @return 实体对象
	 */
	public T find(Class<T> entityClass, Integer entityId);
	/**
	 * 分页
	 * @return
	 */
	public Pager<T> pagerFind(String str, Object obj)throws Exception;
}
