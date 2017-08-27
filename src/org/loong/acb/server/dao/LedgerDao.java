package org.loong.acb.server.dao;

import java.util.List;

import org.loong.acb.server.model.Ledger;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface LedgerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Ledger record);

    int insertSelective(Ledger record);

    Ledger selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ledger record);

    int updateByPrimaryKey(Ledger record);
    
    /**
     * 通过帐号获取所有分账
     * @param parameter
     * @return
     */
    List<Ledger> selectAllByAccount(JSONObject parameter);

    /**
     * 根据分账类别查找用户分账信息
     * @param params
     * @return
     */
	Ledger selectByName(JSONObject params);
}