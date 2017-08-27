package org.loong.acb.wap.controller;

import org.loong.acb.server.service.BillService;
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

@Controller("WapBillController")
@RequestMapping("/wap/bill")
public class BillController {

	@Autowired
	private BillService billServiceImpl;
	
	/**
	 * 入账
	 * @return
	 */
	@PostMapping(value="/income", produces="application/json; charset=utf-8")
	@ResponseBody
	public String income(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = billServiceImpl.income(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
	
	/**
	 * 出账
	 * @return
	 */
	@PostMapping(value="/defray", produces="application/json; charset=utf-8")
	@ResponseBody
	public String defray(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = billServiceImpl.defray(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
	
	/**
	 * 平账
	 * @return
	 */
	@PostMapping(value="/flat", produces="application/json; charset=utf-8")
	@ResponseBody
	public String flat(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = billServiceImpl.flat(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
	
	/**
	 * 获取最新账单
	 * @return
	 */
	@PostMapping(value="/getalluptodatebills", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getalluptodatebills(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = billServiceImpl.getAllUpToDateBills(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
