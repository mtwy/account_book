package org.loong.acb.server.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
	public ReturnSimpleHandle income(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		try{
			String account = StringUtils.toString(parameter.get("account"), "");
			String fundsSources = StringUtils.toString(parameter.get("fundsSources"), "");
			String fundsTrend = StringUtils.toString(parameter.get("fundsTrend"), "");
			String money = StringUtils.toString(parameter.get("money"), "");
			String remarks = StringUtils.toString(parameter.get("remarks"), "");
			String type = StringUtils.toString(parameter.get("type"), "");
			Date curDate = new Date();
			
			// 创建账单
			Bill bill = new Bill();
			bill.setAccount(account);
			bill.setFundsSources(fundsSources);
			bill.setFundsTrend(fundsTrend);
			bill.setMoney(new BigDecimal(money));
			bill.setRemarks(remarks);
			bill.setType(type);
			bill.setCreatedAt(curDate);
			bill.setUpdatedAt(curDate);
			bill.setDelFlag(false);
			billDao.insertSelective(bill);
			
			// 更新分账余额
			JSONObject params = new JSONObject();
			params.put("account", account);
			params.put("name", fundsTrend);
			Ledger ledger = ledgerDao.selectByName(params);
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

	/**
	 * 出账
	 */
	@Override
	public ReturnSimpleHandle defray(JSONObject parameter) throws LoongException {

		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		try{
			String account = StringUtils.toString(parameter.get("account"), "");
			String fundsTrend = StringUtils.toString(parameter.get("fundsTrend"), "");
			String money = StringUtils.toString(parameter.get("money"), "");
			String remarks = StringUtils.toString(parameter.get("remarks"), "");
			String type = StringUtils.toString(parameter.get("type"), "");
			String fundsSources = StringUtils.toString(parameter.get("fundsSources"), "0");
			Date curDate = new Date();
			
			// 创建账单
			Bill bill = new Bill();
			bill.setAccount(account);
			bill.setFundsSources(fundsSources);
			bill.setFundsTrend(fundsTrend);
			bill.setMoney(new BigDecimal(money));
			bill.setRemarks(remarks);
			bill.setType(type);
			bill.setCreatedAt(curDate);
			bill.setUpdatedAt(curDate);
			bill.setDelFlag(false);
			
			// 更新分账余额
			JSONObject params = new JSONObject();
			params.put("account", account);
			params.put("name", fundsSources);
			Ledger ledger = ledgerDao.selectByName(params);
			if(bill.getMoney().compareTo(ledger.getBalance()) > 0){
				throw new LoongException("账户余额不足");
			}
			ledger.setBalance(ledger.getBalance().subtract(bill.getMoney()));
			ledger.setUpdatedAt(curDate);
			
			// 跟新总资产余额
			Asset asset = assetDao.selectByAccount(parameter);
			asset.setBalance(asset.getBalance().subtract(bill.getMoney()));
			asset.setUpdatedAt(curDate);
			
			billDao.insertSelective(bill);
			ledgerDao.updateByPrimaryKeySelective(ledger);
			assetDao.updateByPrimaryKeySelective(asset);
		}catch (Exception e) {
			throw new LoongException(e.getMessage());
		}
		return handle;
	}

	/**
	 * 平账
	 */
	@Override
	public ReturnSimpleHandle flat(JSONObject parameter) throws LoongException {

		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		try{
			String account = StringUtils.toString(parameter.get("account"), "");
			String fundsSources = StringUtils.toString(parameter.get("fundsSources"), "");
			String fundsTrend = StringUtils.toString(parameter.get("fundsTrend"), "");
			String money = StringUtils.toString(parameter.get("money"), "");
			String remarks = StringUtils.toString(parameter.get("remarks"), "");
			String type = StringUtils.toString(parameter.get("type"), "");
			Date curDate = new Date();
			
			// 创建账单
			Bill bill = new Bill();
			bill.setAccount(account);
			bill.setFundsSources(fundsSources);
			bill.setFundsTrend(fundsTrend);
			bill.setMoney(new BigDecimal(money));
			bill.setRemarks(remarks);
			bill.setType(type);
			bill.setCreatedAt(curDate);
			bill.setUpdatedAt(curDate);
			bill.setDelFlag(false);
			billDao.insertSelective(bill);
			
			// 更新分账余额
			JSONObject params = new JSONObject();
			params.put("account", account);
			params.put("name", fundsSources);
			Ledger ledger = ledgerDao.selectByName(params);
			if(bill.getMoney().compareTo(ledger.getBalance()) > 0){
				throw new LoongException("账户余额不足");
			}
			ledger.setBalance(ledger.getBalance().subtract(bill.getMoney()));
			ledger.setUpdatedAt(curDate);
			ledgerDao.updateByPrimaryKeySelective(ledger);
			
			// 更新分账余额
			params = new JSONObject();
			params.put("account", account);
			params.put("name", fundsTrend);
			ledger = ledgerDao.selectByName(params);
			ledger.setBalance(ledger.getBalance().add(bill.getMoney()));
			ledger.setUpdatedAt(curDate);
			ledgerDao.updateByPrimaryKeySelective(ledger);
			
			billDao.insertSelective(bill);
		}catch (Exception e) {
			throw new LoongException(e.getMessage());
		}
		return handle;
	}

	@Override
	public ReturnSimpleHandle getAllUpToDateBills(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		parameter.put("start", 0);
		parameter.put("pageCount", 5);
		List<Bill> bills = billDao.selectAll(parameter);
		handle.setData(bills);
		return handle;
	}
}
