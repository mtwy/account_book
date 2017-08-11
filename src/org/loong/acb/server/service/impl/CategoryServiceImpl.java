package org.loong.acb.server.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.loong.acb.server.dao.BillDao;
import org.loong.acb.server.dao.CategoryDao;
import org.loong.acb.server.model.Bill;
import org.loong.acb.server.model.Category;
import org.loong.acb.server.service.CategoryService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.loong.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private BillDao billDao;
	
	/**
	 * 获取所有
	 */
	@Override
	public ReturnSimpleHandle getAll(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		List<Category> data = categoryDao.selectAll(parameter);
		
		handle.setData(data);
		return handle;
	}

	/**
	 * 一对多关联查询获取所有
	 */
	@Override
	public ReturnSimpleHandle getAllWithRelations(JSONObject parameter) throws LoongException {

		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		List<Category> data = categoryDao.selectRelationsWithChildren(parameter);
		
		handle.setData(data);
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
			String payMethod = StringUtils.toString(parameter.get("payMethod"), "");
			
			Bill bill = new Bill();
			bill.setAccount(account);
			bill.setFundsSources(fundsSources);
			bill.setFundsTrend(fundsTrend);
			bill.setMoney(new BigDecimal(money));
			bill.setRemarks(remarks);
			bill.setType(type);
			bill.setPayMethod(payMethod);
			billDao.insertSelective(bill);
		}catch (Exception e) {
			throw new LoongException(e.getMessage());
		}
		return handle;
	}
}
