package com.piazza.app.mapper;

import java.sql.SQLException;

import com.piazza.app.domain.AppVO;

public interface AppMapper {
	public void addApp(AppVO appVO) throws SQLException;

	public void addAppHis(AppVO appVO) throws SQLException;
	
	public void updateApp(AppVO appVO) throws SQLException;

	public AppVO getApp(AppVO appVO) throws SQLException;

	public void updateAppHis(AppVO appVO) throws SQLException;
	
	public AppVO getAppHis(AppVO appVO) throws SQLException;
//
//	public List<UsageVO> getUserUseHistory(UserVO userVO) throws SQLException;
//	
//	public List<PaymentVO> getUserPaymentHistory(UserVO userVO) throws SQLException;
//	
//	public List<HashMap<String, Object>> getCurrentPayUser(UserVO userVO) throws SQLException;
//	
//	public int getUserInfoCount(UserVO userVO) throws SQLException;
//	
//	public int getDuplicateUser(UserVO userVO) throws SQLException;
//	
//	public int getPayCount(UserVO userVO) throws SQLException;
//	
//	public List<HashMap> getUserList() throws SQLException;
//
//	public void add(UserVO userVO) throws SQLException;
//	
//	public void addStatus(UserStatusVO userStatusVO) throws SQLException;
//	
//	public void updateStatus(UserStatusVO userStatusVO) throws SQLException;
//	
//	public void updateUser(UserVO userVO) throws SQLException;
//		
//	public UserStatusVO getUseStatus(UserVO userVO) throws SQLException;
//	
//	public void insertUsage(UsageVO UsageVO) throws SQLException;
//	
//	public void updateUserStatus(UserStatusVO userStatusVO) throws Exception;
//	
//	public void expier(UserVO userVO) throws SQLException;
	
}
