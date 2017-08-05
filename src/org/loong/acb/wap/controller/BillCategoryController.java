package org.loong.acb.wap.controller;

import org.loong.acb.server.service.BillCategoryService;
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

@Controller("WapBillCategoryController")
@RequestMapping("/wap/billcate")
public class BillCategoryController {

	@Autowired
	private BillCategoryService billCategoryServiceImpl;
	
	/**
	 * 获取所有
	 * @return
	 */
	@PostMapping(value="/getall", produces="application/json; charset=utf-8")
	@ResponseBody
	public String login(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = billCategoryServiceImpl.getAll(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
