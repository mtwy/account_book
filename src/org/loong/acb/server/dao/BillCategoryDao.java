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
    
    /**
     * 查询所有
     * @param parameter
     * @return
     */
    List<BillCategory> selectAll(JSONObject parameter);
    
    /**
     * 根据id获取所有子类别
     * @param parameter
     * @return
     */
    List<BillCategory> selectAllChildById(JSONObject parameter);
    
    /**
     * 一对多查询所有类别
     * @param parameter
     * @return
     */
    List<BillCategory> selectRelationsWithChildren(JSONObject parameter);
}