package com.lender.dao;

import java.util.List;

import com.lender.pojo.LenderVO;

public interface RegisterMapper {
    public int insertRegisterInfo(LenderVO lender);

    public int deleteByTelphone(String telphone);

    public LenderVO getLenderByTelphone(String telphone);
}
