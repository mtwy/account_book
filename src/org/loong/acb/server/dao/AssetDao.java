package org.loong.acb.server.dao;

import org.loong.acb.server.model.Asset;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface AssetDao {
    int deleteByPrimaryKey(Long id);

    int insert(Asset record);

    int insertSelective(Asset record);

    Asset selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Asset record);

    int updateByPrimaryKey(Asset record);
    
    /**
     * 根据帐号查找
     * @param parameter
     * @return
     */
    Asset selectByAccount(JSONObject parameter);
}