package com.lender.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.lender.common.StringHelp;
import com.lender.dao.RegisterMapper;
import com.lender.service.RegisterService;
import com.lender.vo.LenderVO;

@Service
public class RegisterServiceImpl implements RegisterService {
    // private final Logger logger =
    // Logger.getLogger(RegisterServiceImpl.class);
    Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    RegisterMapper registerMapper;

    @Override
    public boolean registerUser(String registerInfo) // throws
						     // RegisterInfoNotCompleteException
    {
	logger.info("enter LoginServiceImpl.registerUser");
	logger.info("parse registerInfo to jsonObject");
	JSONObject jsonObj = JSONObject.parseObject(registerInfo);
	logger.info("parse registerInfo to jsonObject success");
	LenderVO lender = JSONObject.toJavaObject(jsonObj, LenderVO.class);

	if (StringHelp.isEmpty(lender.getUserName()) || StringHelp.isEmpty(lender.getUserTelephone())
		|| StringHelp.isEmpty(lender.getUserIdentityCard()) || StringHelp.isEmpty(lender.getUserPassword())
		|| StringHelp.isEmpty(lender.getConfirmPassword())) {
	    // throw new RegisterInfoNotCompleteException("注册信息不完整 ");
	}

	lender.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
	List<LenderVO> lenderList = new ArrayList<LenderVO>();
	lenderList.add(lender);
	// 手机号进行注册
	registerMapper.deleteByTelphone(lender.getUserTelephone());

	logger.info("insertRegisterInfo to database");
	int count = registerMapper.insertRegisterInfo(lenderList);
	logger.info("leave LoginServiceImpl.registerUser");
	if (count > 0) {
	    return true;
	}
	return false;
    }

}
