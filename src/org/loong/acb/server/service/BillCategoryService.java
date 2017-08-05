package org.loong.acb.server.service;

import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;

import net.sf.json.JSONObject;

public interface BillCategoryService {

	/**
	 * 获取所有
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle getAll(JSONObject parameter) throws LoongException;

	/**
	 * 一对多关联查询获取所有
	 * @param parameter
	 * @return
	 */
	ReturnSimpleHandle getAllWithRelations(JSONObject parameter) throws LoongException;

}
