package org.loong.acb.server.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.loong.acb.server.dao.AssetDao;
import org.loong.acb.server.dao.LoginDao;
import org.loong.acb.server.dao.UserDao;
import org.loong.acb.server.model.Asset;
import org.loong.acb.server.model.Login;
import org.loong.acb.server.model.User;
import org.loong.acb.server.service.LoginRegisterService;
import org.loong.acb.system.constant.EnumConstant;
import org.loong.common.exception.LoongException;
import org.loong.common.retobj.ReturnSimpleHandle;
import org.loong.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.json.JSONObject;

@Service
public class LoginRegisterServiceImpl implements LoginRegisterService{

	@Autowired
	private LoginDao loginDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AssetDao assetDao;
	
	/**
	 * 登录
	 */
	@Override
	public ReturnSimpleHandle login(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		String password = StringUtils.toString(parameter.get("password"), "");
		Login login = loginDao.selectByAccount(parameter);
		if(login == null){
			throw new LoongException("帐号不存在");
		}
		if(!password.equals(login.getPassword())){
			throw new LoongException("密码错误");
		}
		
		User user = userDao.selectByAccount(parameter);
		Asset asset = assetDao.selectByAccount(parameter);
		Map<String, Object> data = new HashMap<>();
		data.put("user", user);
		data.put("asset", asset);
		handle.setData(data);
		return handle;
	}

	@Override
	public ReturnSimpleHandle register(JSONObject parameter) throws LoongException {
		
		ReturnSimpleHandle handle = ReturnSimpleHandle.createHandle();
		
		String account = StringUtils.toString(parameter.get("account"), "");
		String password = StringUtils.toString(parameter.get("password"), "");
		Login login = loginDao.selectByAccount(parameter);
		if(login != null){
			throw new LoongException("帐号已存在");
		}
		
		Date curDate = new Date();
		
		login = new Login();
		login.setAccount(account);
		login.setPassword(password);
		login.setLevel(EnumConstant.LOGIN_LEVEL_NORMAL);
		login.setCreatedAt(curDate);
		login.setUpdatedAt(curDate);
		login.setDelFlag(false);
		loginDao.insertSelective(login);
		
		User user = new User();
		user.setAccount(account);
		user.setLevel(EnumConstant.USER_LEVEL_MASTER);
		user.setCreatedAt(curDate);
		user.setUpdatedAt(curDate);
		user.setDelFlag(false);
		userDao.insertSelective(user);
		
		Asset asset = new Asset();
		asset.setAccount(account);
		asset.setBalance(new BigDecimal(0));
		asset.setCreatedAt(curDate);
		asset.setUpdatedAt(curDate);
		asset.setDelFlag(false);
		assetDao.insertSelective(asset);
		
		handle = login(parameter);
		return handle;
	}
}
