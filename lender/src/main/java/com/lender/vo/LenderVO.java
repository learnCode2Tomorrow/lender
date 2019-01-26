package com.lender.vo;

/**
 * lender information entity class
 * 
 * @author q1238
 *
 */
public class LenderVO {
    /**
     * user unique id
     */
    private String userId;
    /**
     * user login account
     */
    private String userAccount;
    /**
     * user real name
     */
    private String userName;
    /**
     * telephone
     */
    private String userTelephone;
    /**
     * card
     */
    private String userIdentityCard;
    /**
     * address
     */
    private String userAddress;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户email
     */
    private String userEmail;

    private String vrifyCode;

    private String confirmPassword;

    public String getConfirmPassword() {
	return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
    }

    public String getVrifyCode() {
	return vrifyCode;
    }

    public void setVrifyCode(String vrifyCode) {
	this.vrifyCode = vrifyCode;
    }

    public String getUserPassword() {
	return userPassword;
    }

    public void setUserPassword(String userPassword) {
	this.userPassword = userPassword;
    }

    public String getUserEmail() {
	return userEmail;
    }

    public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
    }

    public String getUserId() {
	return userId;
    }

    public void setUserId(String userId) {
	this.userId = userId;
    }

    public String getUserAccount() {
	return userAccount;
    }

    public void setUserAccount(String userAccount) {
	this.userAccount = userAccount;
    }

    public String getUserName() {
	return userName;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }

    public String getUserTelephone() {
	return userTelephone;
    }

    public void setUserTelephone(String userTelephone) {
	this.userTelephone = userTelephone;
    }

    public String getUserIdentityCard() {
	return userIdentityCard;
    }

    public void setUserIdentityCard(String userIdentityCard) {
	this.userIdentityCard = userIdentityCard;
    }

    public String getUserAddress() {
	return userAddress;
    }

    public void setUserAddress(String userAddress) {
	this.userAddress = userAddress;
    }

}
