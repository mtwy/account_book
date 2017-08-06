package org.loong.acb.server.dao;

import org.loong.acb.server.model.Ledger;

public interface LedgerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Ledger record);

    int insertSelective(Ledger record);

    Ledger selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ledger record);

    int updateByPrimaryKey(Ledger record);
}