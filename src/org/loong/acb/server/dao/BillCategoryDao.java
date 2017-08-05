package org.loong.acb.server.dao;

import org.loong.acb.server.model.BillCategory;

public interface BillCategoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(BillCategory record);

    int insertSelective(BillCategory record);

    BillCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BillCategory record);

    int updateByPrimaryKey(BillCategory record);
}