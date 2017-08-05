package org.loong.acb.server.dao;

import org.loong.acb.server.model.User;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface UserDao {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     * 根据帐号查找
     * @param parameter
     * @return
     */
    User selectByAccount(JSONObject parameter);
}