package org.loong.acb.server.service;

import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;

import net.sf.json.JSONObject;

public interface LoginRegisterService {

	/**
	 * 登录
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle login(JSONObject parameter) throws LoongException;

	/**
	 * 注册
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle register(JSONObject parameter) throws LoongException;

}
