package org.loong.acb.wap.controller;

import org.loong.acb.server.service.CategoryService;
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
	private CategoryService categoryServiceImpl;
	
	/**
	 * 入账
	 * @return
	 */
	@PostMapping(value="/ruzhang", produces="application/json; charset=utf-8")
	@ResponseBody
	public String ruZhang(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = categoryServiceImpl.ruZhang(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
