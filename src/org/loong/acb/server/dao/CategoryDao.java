package org.loong.acb.server.dao;

import java.util.List;

import org.loong.acb.server.model.Category;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONObject;

@Repository
public interface CategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);
    
    /**
     * 查询所有
     * @param parameter
     * @return
     */
    List<Category> selectAll(JSONObject parameter);
    
    /**
     * 根据id获取所有子类别
     * @param parameter
     * @return
     */
    List<Category> selectAllChildByParentId(JSONObject parameter);
    
    /**
     * 一对多查询所有类别
     * @param parameter
     * @return
     */
    List<Category> selectRelationsWithChildren(JSONObject parameter);

    /**
     * 根据名称获取类别
     * @param param
     */
    Category selectByName(JSONObject param);
}