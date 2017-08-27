package org.loong.acb.server.service;

import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;

import net.sf.json.JSONObject;

public interface AssetService {

	/**
	 * 获取最新资产
	 * @param parameter
	 * @return
	 * @throws LoongException
	 */
	ReturnSimpleHandle getUpToDateAsset(JSONObject parameter) throws LoongException;

}
