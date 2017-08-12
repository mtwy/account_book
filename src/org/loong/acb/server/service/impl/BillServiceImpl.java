package org.loong.acb.server.service.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.loong.acb.server.dao.AssetDao;
import org.loong.acb.server.dao.BillDao;
import org.loong.acb.server.dao.LedgerDao;
import org.loong.acb.server.model.Asset;
import org.loong.acb.server.model.Bill;
import org.loong.acb.server.model.Ledger;
import org.loong.acb.server.service.BillService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.loong.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service
public class BillServiceImpl implements BillService{

	@Autowired
	private BillDao billDao;
	
	@Autowired
	private AssetDao assetDao;
	
	@Autowired
	private LedgerDao ledgerDao;
	
	/**
	 * 获取所有
	 */
	@Override
	public ReturnSimpleHandle getAll(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		return handle;
	}

	/**
	 * 入账
	 */
	@Override
	public ReturnSimpleHandle ruZhang(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		try{
			String account = StringUtils.toString(parameter.get("account"), "");
			String fundsSources = StringUtils.toString(parameter.get("fundsSources"), "");
			String fundsTrend = StringUtils.toString(parameter.get("fundsTrend"), "");
			String money = StringUtils.toString(parameter.get("money"), "");
			String remarks = StringUtils.toString(parameter.get("remarks"), "");
			String type = StringUtils.toString(parameter.get("type"), "");
			JSONArray payMethod = parameter.getJSONArray("payMethod");
			Date curDate = new Date();
			
			// 创建账单
			Bill bill = new Bill();
			bill.setAccount(account);
			bill.setFundsSources(fundsSources);
			bill.setFundsTrend(fundsTrend);
			bill.setMoney(new BigDecimal(money));
			bill.setRemarks(remarks);
			bill.setType(type);
			bill.setPayMethod(payMethod.toString());
			bill.setCreatedAt(curDate);
			bill.setUpdatedAt(curDate);
			bill.setDelFlag(false);
			billDao.insertSelective(bill);
			
			// 更新分账余额
			JSONObject params = new JSONObject();
			params.put("account", account);
			params.put("cateId", payMethod.getLong(0));
			Ledger ledger = ledgerDao.selectByCateId(params);
			ledger.setBalance(ledger.getBalance().add(bill.getMoney()));
			ledger.setUpdatedAt(curDate);
			ledgerDao.updateByPrimaryKeySelective(ledger);
			
			// 跟新总资产余额
			Asset asset = assetDao.selectByAccount(parameter);
			asset.setBalance(asset.getBalance().add(bill.getMoney()));
			asset.setUpdatedAt(curDate);
			assetDao.updateByPrimaryKeySelective(asset);
		}catch (Exception e) {
			throw new LoongException(e.getMessage());
		}
		return handle;
	}
}
