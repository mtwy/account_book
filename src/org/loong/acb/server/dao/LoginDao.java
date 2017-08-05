package org.loong.acb.server.dao;

import org.loong.acb.server.model.Login;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface LoginDao {
    int deleteByPrimaryKey(Long id);

    int insert(Login record);

    int insertSelective(Login record);

    Login selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);
    
    /**
     * 根据帐号查找
     * @param parameter
     * @return
     */
    Login selectByAccount(JSONObject parameter);
}