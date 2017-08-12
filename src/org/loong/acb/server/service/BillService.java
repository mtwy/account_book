package org.loong.acb.server.service;

import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;

import net.sf.json.JSONObject;

public interface BillService {

	/**
	 * 获取所有
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle getAll(JSONObject parameter) throws LoongException;

	/**
	 * 入账
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle ruZhang(JSONObject parameter) throws LoongException;

}
