package com.lender.dao;

import java.util.List;

import com.lender.vo.LenderVO;

public interface RegisterMapper
{
	public int insertRegisterInfo(List<LenderVO> lender);

	public int deleteByTelphone(String telphone);
}
