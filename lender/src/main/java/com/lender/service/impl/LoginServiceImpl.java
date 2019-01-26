package com.lender.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lender.common.StringHelp;
import com.lender.dao.LoginMapper;
import com.lender.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
    private final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    LoginMapper loginMapper;

    @Override
    public boolean login(String userTelephone, String userPassword) {
	if (StringHelp.isEmpty(userTelephone)) {
	    logger.error("user account is empty");
	    return false;
	}
	if (StringHelp.isEmpty(userPassword)) {
	    logger.error("user password is empty");
	    return false;
	}
	String userId = loginMapper.getUserId(userTelephone, userPassword);
	if (StringHelp.isEmpty(userId)) {
	    logger.info("user telphone {} login success!", userTelephone);
	    return true;
	}
	logger.info("user telphone {} login fail", userTelephone);
	return true;
    }
}
