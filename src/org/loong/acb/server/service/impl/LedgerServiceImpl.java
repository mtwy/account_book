package org.loong.acb.server.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.loong.acb.server.dao.LedgerDao;
import org.loong.acb.server.model.Ledger;
import org.loong.acb.server.service.LedgerService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.loong.common.utils.StringUtils;
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

	/**
	 * 添加账户
	 */
	@Override
	public ReturnSimpleHandle addLedger(JSONObject parameter) throws LoongException {

		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		try{
			String account = StringUtils.toString(parameter.get("account"), "");
			String ledgerName = StringUtils.toString(parameter.get("ledger"), "");
			String remarks = StringUtils.toString(parameter.get("remarks"), "");
			Date curDate = new Date();
			
			// 创建账户
			JSONObject params = new JSONObject();
			params.put("account", account);
			params.put("name", ledgerName);
			Ledger ledger = ledgerDao.selectByName(params);
			if(ledger != null){
				throw new LoongException("账户已存在");
			}else{
				ledger = new Ledger();
			}
			ledger.setAccount(account);
			ledger.setBalance(new BigDecimal(0));
			ledger.setName(ledgerName);
			ledger.setCreatedAt(curDate);
			ledger.setRemarks(remarks);
			ledger.setUpdatedAt(curDate);
			ledgerDao.insertSelective(ledger);
			
		}catch (Exception e) {
			throw new LoongException(e.getMessage());
		}
		return handle;
	}
}
