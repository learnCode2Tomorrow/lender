package com.lender.service;

import com.lender.exception.RegisterException;
import com.lender.exception.RegisterMsgNotCompleteException;

public interface RegisterService {
    public boolean registerUser(String registerInfo) throws RegisterMsgNotCompleteException, RegisterException;
}
