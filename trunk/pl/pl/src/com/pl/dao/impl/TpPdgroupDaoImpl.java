package com.pl.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.pl.common.base.BaseDao;
import com.pl.dao.TpPdgroupDao;
import com.pl.tdo.TpPdgroupBean;

public class TpPdgroupDaoImpl extends BaseDao implements TpPdgroupDao {

	public int delete(List<TpPdgroupBean> list) throws SQLException {
		this.getSqlMapClientTemplate().getSqlMapClient().startBatch();
		for (TpPdgroupBean tpPdgroupBean : list) {
			super.delete("tp_pdgroup.deleteByProductId", tpPdgroupBean);
		}
		return this.getSqlMapClientTemplate().getSqlMapClient().executeBatch();
	}

	public int insert(List<TpPdgroupBean> list) throws SQLException {

		this.getSqlMapClientTemplate().getSqlMapClient().startBatch();
		short seq = 0;
		if (list.size() > 0) {
			seq = (Short) super.selectOne("tp_pdgroup.selectMaxSeqByGroupId",
					list.get(0).getGroupId());
		}
		for (TpPdgroupBean tpPdgroupBean : list) {
			seq++;
			tpPdgroupBean.setSeq(seq);
			super.insert("tp_pdgroup.insert", tpPdgroupBean);
		}
		return this.getSqlMapClientTemplate().getSqlMapClient().executeBatch();

	}
}