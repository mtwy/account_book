package org.loong.acb.server.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.loong.acb.server.dao.AssetDao;
import org.loong.acb.server.dao.LedgerDao;
import org.loong.acb.server.model.Asset;
import org.loong.acb.server.model.Ledger;
import org.loong.acb.server.service.AssetService;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class AssetServiceImpl implements AssetService{

	@Autowired
	private LedgerDao ledgerDao;
	
	@Autowired
	private AssetDao assetDao;
	
	/**
	 * 获取最新资产
	 */
	@Override
	public ReturnSimpleHandle getUpToDateAsset(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		Asset asset = assetDao.selectByAccount(parameter);
		List<Ledger> ledgers = ledgerDao.selectAllByAccount(parameter);
		
		Map<String, Object> data = new HashMap<>();
		data.put("asset", asset);
		data.put("ledgers", ledgers);
		handle.setData(data);
		return handle;
	}
}
