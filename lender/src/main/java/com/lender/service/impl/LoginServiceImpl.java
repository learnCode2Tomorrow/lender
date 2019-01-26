package com.lender.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lender.common.StringHelp;
import com.lender.dao.LoginMapper;
import com.lender.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    private final Logger logger = Logger.getLogger(LoginServiceImpl.class);

    @Autowired
    LoginMapper loginMapper;

    @Override
    public boolean login(String userTelephone, String userPassword) {

	if (StringHelp.isEmpty(userTelephone)) {
	    logger.error("user account is empty");
	    return false;
	}

	if (StringHelp.isEmpty(userPassword)) {
	    logger.error("user account is empty");
	    return false;
	}

	String userId = loginMapper.getUserId(userTelephone, userPassword);

	if (!StringHelp.isEmpty(userId)) {
	    logger.info("user :{" + userId + "}login success");
	    return true;
	}

	logger.info("user account :{" + userTelephone + "}login fail");
	return false;
    }
}
