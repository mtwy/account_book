package org.loong.acb.server.dao;

import org.loong.acb.server.model.BillDetails;

public interface BillDetailsDao {
    int deleteByPrimaryKey(Long id);

    int insert(BillDetails record);

    int insertSelective(BillDetails record);

    BillDetails selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BillDetails record);

    int updateByPrimaryKey(BillDetails record);
}