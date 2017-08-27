package org.loong.acb.server.dao;

import java.util.List;

import org.loong.acb.server.model.Bill;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface BillDao {
    int deleteByPrimaryKey(Long id);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);

    /**
     * 获取所有
     * @param parameter
     * @return
     */
	List<Bill> selectAll(JSONObject parameter);
}