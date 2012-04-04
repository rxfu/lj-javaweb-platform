package com.pl.common.base;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.pl.common.pager.Pager;

/**
 * Dao的抽象类，用户规范Dao的格式。 所有的Dao必须继承自此类。
 * 
 * @author 熊庆春
 * 
 */
public abstract class BaseDao extends SqlMapClientDaoSupport {
	private static final long serialVersionUID = 1L;
	public BaseDao(){
		SQLExceptionTranslator tr = new SQLErrorCodeSQLExceptionTranslator("MySQL");
		this.getSqlMapClientTemplate().setExceptionTranslator(tr);
	}

	/**
	 * 查询列表
	 * @param statementName
	 * @param obj
	 * @return
	 */
	public List<?> selectList(String statementName,Object obj) {
		return this.getSqlMapClientTemplate().queryForList(statementName, obj);
	}
	/**
	 * 查询列表
	 * @param statementName
	 * @param obj
	 * @return
	 */
	public List<?> selectList(String statementName,Object obj,int skipResults,int maxResults) {
		return this.getSqlMapClientTemplate().queryForList(statementName, obj, skipResults, maxResults);
	}

	/**
	 * 分页的查询
	 * @param statementName
	 * @param obj
	 * @param pager
	 * @return
	 */
	public List<?> selectPager(String statementName, Object obj, Pager pager) {
		List<?> list = getSqlMapClientTemplate().queryForList(statementName, obj,pager.getOffset(), pager.getMaxPageItems());
		//如果获得的结果集和页最大记录数不相同，这表示是最后一页。
		//如果也最大记录数不为9999，表示没有计算过总记录数。
		//结果：需要计算总记录数
		if (list.size() != pager.getMaxPageItems() && pager.getItems() == 9999) 
		{
			int items = (Integer) getSqlMapClientTemplate().queryForObject(statementName + "Count", obj);
			pager.setItems(items);
			//如果总记录数为0
			//如果最大页数等于当前页数
			//结果:可以不从新获取列表数据，否则从新获取列表数据。
			if (pager.getItems() != 0 && pager.getMaxOffset() != pager.getOffset()) 
			{
				pager.setOffset(pager.getMaxOffset());
				list = getSqlMapClientTemplate().queryForList(statementName,obj, pager.getOffset(), pager.getMaxPageItems());
			}
		}
		return list;
	}
	/**
	 * 单个查询
	 * @param statementName ibatis SQLId
	 * @param obj 查询条件
	 * @return 实体类
	 */
	public Object selectOne(String statementName,Object obj) {
		return this.getSqlMapClientTemplate().queryForObject(statementName, obj);
	}

	/**
	 * 将obj插入数据库
	 * 
	 * @param obj
	 *            ibatis参数 实体类
	 * @return
	 */
	public Object insert(String statementName,Object obj) {
		return this.getSqlMapClientTemplate()
				.insert(statementName, obj);
	}

	/**
	 * 根据主键删除数据库的值
	 * 
	 * @param obj
	 *            ibatis参数，可以是String 也可以是实体类
	 * @throws SQLException
	 *             如果删除数据熟练不是1，则抛出异常SQLException("通过Id删除数据未成功")
	 */
	public void deleteById(String statementName,Object obj) throws SQLException {
		int flag = this.getSqlMapClientTemplate().delete(
				statementName, obj);
		if (1 != flag) {
			throw new SQLException("通过Id删除数据未成功");
		}
	}

	/**
	 * 删除 ibatis参数，可以是String 也可以是实体类
	 * 
	 * @param obj
	 *            ibatis参数，可以是String 也可以是实体类
	 * @return 删除数据量
	 * @throws SQLException 
	 */
	public int delete(String statementName,Object obj) throws SQLException {
		int flag = this.getSqlMapClientTemplate()
				.delete(statementName, obj);
		if (1 < flag) {
			throw new SQLException("删除了0条数据");
		}
		return flag;
	}

	/**
	 * 更新数据库
	 * 
	 * @param obj
	 *            需要更新的实体类
	 * @return
	 * @throws SQLException 
	 */
	public int update(String statementName,Object obj) throws SQLException {
		int flag = this.getSqlMapClientTemplate().update(statementName, obj);
		if (1 < flag) {
			throw new SQLException("未成功更新任何数据");
		}
		return flag;
	}

}
