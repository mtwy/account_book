package org.loong.acb.wap.controller;

import org.loong.acb.server.service.LedgerService;
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

@Controller("WapLedgerController")
@RequestMapping("/wap/ledger")
public class LedgerController {

	@Autowired
	private LedgerService ledgerServiceImpl;
	
	/**
	 * 根据帐号获取所有
	 * @return
	 */
	@PostMapping(value="/getallbyaccount", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getAllByAccount(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = ledgerServiceImpl.getAllByAccount(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
