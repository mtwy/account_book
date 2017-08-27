package org.loong.acb.wap.controller;

import org.loong.acb.server.service.AssetService;
import org.loong.common.content.RequestContent;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnPaginateHandle;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;

@Controller("WapAssetController")
@RequestMapping("/wap/asset")
public class AssetController {

	@Autowired
	private AssetService assetServiceImpl;
	
	/**
	 * 获取最新资产
	 * @return
	 */
	@PostMapping(value="/getuptodateasset", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getUpToDateAsset(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = assetServiceImpl.getUpToDateAsset(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
