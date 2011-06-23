package com.pl.dao.impl;

import java.sql.SQLException;

import com.pl.common.base.BaseDao;
import com.pl.dao.TpPdgroupDao;
import com.pl.exception.PlException;
import com.pl.tdo.TpPdgroupBean;

public class TpPdgroupDaoImpl extends BaseDao implements TpPdgroupDao {

	public int delete(String productId) throws SQLException {
		return super.delete("tp_pdgroup.deleteByProductId", productId);
	}

	public TpPdgroupBean insert(TpPdgroupBean tpPdgroupBean) throws PlException {
		if(tpPdgroupBean.getSeq()==0){
			short seq = (Short) super.selectOne("tp_pdgroup.selectMaxSeqByGroupId", tpPdgroupBean.getGroupId());
			seq++;
			tpPdgroupBean.setSeq(seq);
		}
		return (TpPdgroupBean) super.insert("tp_pdgroup.insert",tpPdgroupBean);
	}

}