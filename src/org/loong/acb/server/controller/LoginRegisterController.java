package org.loong.acb.server.controller;

import org.loong.acb.server.service.LoginRegisterService;
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

@Controller("serverLoginRegisterController")
@RequestMapping("/server/account")
public class LoginRegisterController {

	@Autowired
	private LoginRegisterService loginRegisterServiceImpl;
	
	/**
	 * 登录
	 * @return
	 */
	@PostMapping(value="/login", produces="application/json; charset=utf-8")
	@ResponseBody
	public String login(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = loginRegisterServiceImpl.login(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
	
	/**
	 * 注册
	 * @return
	 */
	@PostMapping(value="/register", produces="application/json; charset=utf-8")
	@ResponseBody
	public String register(){
		
		ReturnSimpleHandle handle = null;
		try {
			JSONObject parameter = RequestContent.receiveParameter();
			handle = loginRegisterServiceImpl.register(parameter);
		} catch (LoongException e) {
			handle = ReturnSimpleHandle.createServerError(e.getMessage());
		}  catch (Exception e) {
			e.printStackTrace();
			handle = ReturnPaginateHandle.createServerError();
		}
		return handle.toJson();
	}
}
