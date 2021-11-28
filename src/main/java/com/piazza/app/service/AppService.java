package com.piazza.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piazza.app.domain.AppVO;
import com.piazza.app.mapper.AppMapper;

@Transactional
@Service
public class AppService {

	private static final Logger logger = LoggerFactory.getLogger(AppService.class);

	@Autowired
	AppMapper appMapper;

	public AppVO getApp(AppVO appVO) throws Exception {
		AppVO result = appMapper.getApp(appVO);
		return result;
	}
	
	public AppVO getAppHis(AppVO appVO) throws Exception {
		AppVO result = appMapper.getAppHis(appVO);
		return result;
	}

	public void addApp(AppVO appVO) throws Exception {
		this.appMapper.addApp(appVO);
	}

	public void addAppHis(AppVO appVO) throws Exception {
		this.appMapper.addAppHis(appVO);
	}

	public void updateAppHis(AppVO appVO) throws Exception {
		this.appMapper.updateAppHis(appVO);
	}
	
	public void updateApp(AppVO appVO) throws Exception {
		this.appMapper.updateApp(appVO);
	}
}
