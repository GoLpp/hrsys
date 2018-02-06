package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrsys.dao.IDownloadDao;
import com.hrsys.dao.IUserDao;
import com.hrsys.exception.DownloadException;
import com.hrsys.pojo.DownLoad;
import com.hrsys.pojo.User;
import com.hrsys.service.IDownloadService;
import com.hrsys.utils.ObjectUtils;

public class DownloadService implements IDownloadService{
	private IDownloadDao downLoadDao = null;
	private IUserDao userDao = null;
	public DownloadService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		downLoadDao = ObjectUtils.getObject("downloadDao");
		userDao = ObjectUtils.getObject("userDao");
	}
	@Override
	public List<DownLoad> findAllDownload() throws SQLException {
		List<DownLoad> downLoads = downLoadDao.findAllDownload();
		List<DownLoad> returnDownLoads = new ArrayList<>();
		addUserToDownloads(downLoads, returnDownLoads);
		return returnDownLoads;
	}
	/**
	 * 
	 * @Title: addUserToDownloads 
	 * @Description: 设置download中的user
	 * @param @param downLoads
	 * @param @param returnDownLoads
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void addUserToDownloads(List<DownLoad> downLoads, List<DownLoad> returnDownLoads) throws SQLException {
		User user = new User();
		for(DownLoad downLoad:downLoads) {
			user.setuId(downLoad.getuId());
			user = userDao.findUserById(user);
			downLoad.setUser(user);
			returnDownLoads.add(downLoad);
		}
	}

	@Override
	public DownLoad findDownloadById(DownLoad downLoad) throws SQLException {
		if(downLoad.getDoId() == null) {
			throw new DownloadException("输入参数错误");
		}
		return downLoadDao.findDownloadById(downLoad);
	}

	@Override
	public List<DownLoad> findDownloadByCondition(DownLoad downLoad) throws SQLException {
		return downLoadDao.findDownloadByCondition(downLoad);
	}

	@Override
	public void removeDownload(DownLoad downLoad) throws SQLException {
		if(downLoad.getDoId() == null) {
			throw new DownloadException("输入参数错误");
		}
		downLoadDao.removeDownload(downLoad);
	}

	@Override
	public void updateDownload(DownLoad downLoad) throws SQLException {
		if(downLoad.getDoDescrip().equals("") ||
			downLoad.getDoTitle().equals("") || downLoad.getuId() == null ||
			downLoad.getUrl() == null) {
			throw new DownloadException("输入参数错误");
		}
		downLoadDao.updateDownload(downLoad);
	}

	@Override
	public void insert(DownLoad downLoad) throws SQLException {
		if(downLoad.getDoDescrip().equals("") ||
				downLoad.getDoTitle().equals("") ||
				downLoad.getUrl() == null) {
				throw new DownloadException("输入参数错误");
			}
		downLoadDao.insert(downLoad);
	}
}
