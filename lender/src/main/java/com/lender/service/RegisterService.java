package com.lender.service;

import exception.RegisterInfoNotCompleteException;

public interface RegisterService
{
	public boolean registerUser(String registerInfo) throws RegisterInfoNotCompleteException;

}
