package org.loong.acb.server.service.impl;

import java.util.List;

import org.loong.acb.server.dao.LedgerDao;
import org.loong.acb.server.model.Ledger;
import org.loong.acb.server.service.LedgerService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class LedgerServiceImpl implements LedgerService{

	@Autowired
	private LedgerDao ledgerDao;
	
	/**
	 * 根据帐号获取所有
	 */
	@Override
	public ReturnSimpleHandle getAllByAccount(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		List<Ledger> data = ledgerDao.selectAllByAccount(parameter);
		
		handle.setData(data);
		return handle;
	}
}
