package com.lender.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lender.common.RestResult;
import com.lender.service.RegisterService;

/**
 * register user information
 * 
 * @author q1238
 *
 */
@RestController
@RequestMapping("/lender/registerCtrl")
public class RegisterCtroller
{
	private final Logger logger = Logger.getLogger(RegisterCtroller.class);
	@Autowired
	RegisterService loginService;

	@RequestMapping("/register")
	public RestResult<String> register(@RequestParam("registerInfo") String registerInfo)
	{
		logger.info("enter into register");
		RestResult<String> restResult = new RestResult<String>();
		boolean result;
		try
		{
			result = loginService.registerUser(registerInfo);
		} catch (Exception e)
		{
			logger.error("register information not complete" + e.getMessage());
			result = false;
			restResult.setResultCode("20001");
			restResult.setResultMessage(e.getMessage());
		}
		restResult.setResult(result);
		logger.info("leave register");
		return restResult;
	}
}
