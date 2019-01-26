package com.lender.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lender.common.RestResult;
import com.lender.service.LoginService;
import com.lender.vo.LenderVO;

/**
 * login
 * 
 * @author q1238
 *
 */
@RestController
@RequestMapping("/lender/loginCtrl")
public class LoginCtroller {
    private final Logger logger = LoggerFactory.getLogger(LoginCtroller.class);

    @Autowired
    LoginService loginService;

    /**
     * login
     * 
     * @param loginInfo
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping("/login")
    public RestResult<String> login(@RequestParam("loginInfo") String loginInfo, HttpServletRequest httpServletRequest,
	    HttpServletResponse httpServletResponse) {
	logger.info("enter into login");
	RestResult<String> result = new RestResult<String>();
	JSONObject jsonObj = JSON.parseObject(loginInfo);
	LenderVO lender = JSON.toJavaObject(jsonObj, LenderVO.class);
	String userTelephone = lender.getUserTelephone();
	String userPassword = lender.getUserPassword();
	/*
	 * String verifyCode = lender.getVrifyCode(); if
	 * (!verifyKaptcha(httpServletRequest, httpServletResponse, verifyCode))
	 * { result.setResult(false); result.setResultCode("10001"); return
	 * result; }
	 */

	boolean loginResult = loginService.login(userTelephone, userPassword);
	if (loginResult) {
	    httpServletRequest.getSession().setAttribute("userId", UUID.randomUUID().toString().replaceAll("-", ""));
	} else {
	    result.setResultCode("10002");
	}
	result.setResult(loginResult);
	logger.info("leave login");
	return result;
    }

    /**
     * verify code
     * 
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    public boolean verifyKaptcha(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
	    String verifyCode) {
	boolean flag = true;
	String captchaId = (String) httpServletRequest.getSession().getAttribute("vrifyCode");
	logger.info("Session  vrifyCode " + captchaId + " form vrifyCode " + verifyCode);
	if (!captchaId.equals(verifyCode)) {
	    flag = false;
	} else {
	    flag = true;
	}
	return flag;
    }
}
