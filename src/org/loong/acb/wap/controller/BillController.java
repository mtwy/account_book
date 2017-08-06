package org.loong.acb.wap.controller;

import org.loong.acb.server.service.CategoryService;
import org.loong.acb.system.constant.EnumConstant;
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
	private CategoryService billCategoryServiceImpl;
	
	/**
	 * 获取所有
	 * @return
	 */
	@PostMapping(value="/getallcategory", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getAll(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			parameter.put("type", EnumConstant.CATEGORY_TYPE_BILL);
			handle = billCategoryServiceImpl.getAll(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
	
	/**
	 * 一对多关联查询获取所有
	 * @return
	 */
	@PostMapping(value="/getallcategorywithrelations", produces="application/json; charset=utf-8")
	@ResponseBody
	public String getAllCategoryWithRelations(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			parameter.put("type", EnumConstant.CATEGORY_TYPE_BILL);
			handle = billCategoryServiceImpl.getAllWithRelations(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
