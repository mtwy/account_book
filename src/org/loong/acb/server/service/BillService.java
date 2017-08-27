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
	ReturnSimpleHandle income(JSONObject parameter) throws LoongException;

	/**
	 * 出账
	 * @param parameter
	 * @return
	 */
	ReturnSimpleHandle defray(JSONObject parameter) throws LoongException;

	/**
	 * 获取最新账单
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle getAllUpToDateBills(JSONObject parameter) throws LoongException;

	/**
	 * 平账
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle flat(JSONObject parameter) throws LoongException;
}
