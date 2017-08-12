package org.loong.acb.server.service.impl;

import java.util.List;

import org.loong.acb.server.dao.CategoryDao;
import org.loong.acb.server.model.Category;
import org.loong.acb.server.service.CategoryService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryDao categoryDao;
	
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
}
