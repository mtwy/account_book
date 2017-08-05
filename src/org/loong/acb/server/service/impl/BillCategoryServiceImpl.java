package org.loong.acb.server.service.impl;

import java.util.List;

import org.loong.acb.server.dao.BillCategoryDao;
import org.loong.acb.server.model.BillCategory;
import org.loong.acb.server.service.BillCategoryService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class BillCategoryServiceImpl implements BillCategoryService{

	@Autowired
	private BillCategoryDao billCategoryDao;
	
	/**
	 * 获取所有
	 */
	@Override
	public ReturnSimpleHandle getAll(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		List<BillCategory> data = billCategoryDao.selectAll(parameter);
		
		handle.setData(data);
		return handle;
	}

	/**
	 * 一对多关联查询获取所有
	 */
	@Override
	public ReturnSimpleHandle getAllWithRelations(JSONObject parameter) throws LoongException {

		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		List<BillCategory> data = billCategoryDao.selectRelationsWithChildren(parameter);
		
		handle.setData(data);
		return handle;
	}
}
