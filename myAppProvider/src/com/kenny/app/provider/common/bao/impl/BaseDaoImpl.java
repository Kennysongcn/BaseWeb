package com.kenny.app.provider.common.bao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kenny.app.provider.common.bao.BaseDao;
import com.kenny.app.provider.common.util.Pager;
/**
 * 公共dao
 * @author kennysong
 *
 * @param <T>
 */
@Repository("baseDao")
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	//引入sqlSessionTemplate
	//@Autowired
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	/**
	 * 新增对象
	 * @param str
	 * @param entity
	 * @return
	 */
	@Override
	public int save(String str, T entity) throws Exception {
		return sqlSessionTemplate.insert(str,entity);
	}
	/**
	 * 修改对象
	 * @param str
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object update(String str, T entity) throws Exception {
		return sqlSessionTemplate.update(str, entity);
	}

	/**
	 * 批量新增
	 * @param str
	 * @param entitys
	 * @throws Exception
	 */
	@Override
	public Object saveBatch(String str, List<T> entitys) throws Exception {
		return sqlSessionTemplate.update(str, entitys);
	}
	/**
	 * 批量更新
	 * @param str
	 * @param entitys
	 * @throws Exception
	 */
	@Override
	public void updateBatch(String str, List<T> entitys) throws Exception {
		SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
		//批量执行器
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
		try{
			if(entitys!=null){
				for(int i=0,size=entitys.size();i<size;i++){
					sqlSession.update(str, entitys.get(i));
				}
				sqlSession.flushStatements();
				sqlSession.commit();
				sqlSession.clearCache();
			}
		}finally{
			sqlSession.close();
		}
	}
	
	/**
	 * 删除对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object delete(String str, T entity) throws Exception {
		return sqlSessionTemplate.delete(str, entity);
	}
	
	/**
	 * 批量删除
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Object deleteBatch(String str, List objs )throws Exception{
		return sqlSessionTemplate.delete(str, objs);
	}
	/**
	 * 查找对象
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object findForObject(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectOne(str, obj);
	}

	/**
	 * 查找对象 封装成List
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<T> findForList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	
	/**
	 * 查找对象封装成Map
	 * @param sql
	 * @param obj
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@Override
	public Object findForMap(String sql, Object obj, String key, String value)
			throws Exception {
		return sqlSessionTemplate.selectMap(sql, obj, key);
	}

	@Override
	public T find(Class<T> entityClass, Integer entityId) {
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Pager<T> pagerFind(String str, Object obj) {
		return (Pager<T>) sqlSessionTemplate.selectList(str, obj);
	}


}
