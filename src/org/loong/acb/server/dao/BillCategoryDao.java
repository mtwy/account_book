package org.loong.acb.server.dao;

import java.util.List;

import org.loong.acb.server.model.BillCategory;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface BillCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(BillCategory record);

    int insertSelective(BillCategory record);

    BillCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BillCategory record);

    int updateByPrimaryKey(BillCategory record);
    
    List<BillCategory> selectAll(JSONObject parameter);
}