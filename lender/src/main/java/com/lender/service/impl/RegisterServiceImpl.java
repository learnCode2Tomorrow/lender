package com.lender.service.impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lender.common.ErrorCodeMsg;
import com.lender.common.StringHelp;
import com.lender.dao.RegisterMapper;
import com.lender.exception.RegisterException;
import com.lender.exception.RegisterMsgNotCompleteException;
import com.lender.pojo.LenderVO;
import com.lender.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
    Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

    @Autowired
    RegisterMapper registerMapper;

    @Override
    public boolean registerUser(String registerInfo) throws RegisterException {
	logger.info("enter LoginServiceImpl.registerUser");
	JSONObject jsonObj = JSON.parseObject(registerInfo);
	logger.info("parse registerInfo to jsonObject success");
	LenderVO lender = JSON.toJavaObject(jsonObj, LenderVO.class);
	if (StringHelp.isEmpty(lender.getUserName()) || StringHelp.isEmpty(lender.getUserTelephone())
		|| StringHelp.isEmpty(lender.getUserIdentityCard()) || StringHelp.isEmpty(lender.getUserPassword())
		|| StringHelp.isEmpty(lender.getConfirmPassword())) {
	    logger.error("Register lender information not complete");
	    throw new RegisterMsgNotCompleteException(ErrorCodeMsg.REGISTER_INFORMATION_NOT_COMPLETE_CODE,
		    ErrorCodeMsg.REGISTER_INFORMATION_NOT_COMPLETE_MSG);
	}
	if (null != registerMapper.getLenderByTelphone(lender.getUserTelephone())) {
	    logger.error("Telephone {} has be registered", lender.getUserTelephone());
	    throw new RegisterException(ErrorCodeMsg.REGISTER_TELEPHONE_HAVE_USED_CODE,
		    ErrorCodeMsg.REGISTER_TELEPHONE_HAVE_USED_MSG);
	}
	lender.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
	registerMapper.insertRegisterInfo(lender);
	logger.info("Register user {} success telephone");
	return true;
    }

}
