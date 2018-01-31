package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IDownloadDao;
import com.hrsys.exception.DownloadException;
import com.hrsys.pojo.DownLoad;
import com.hrsys.service.IDownloadService;
import com.hrsys.utils.ObjectUtils;

public class DownloadService implements IDownloadService{
	private IDownloadDao downLoadDao = null;
	
	public DownloadService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		downLoadDao = ObjectUtils.getObject("downloadDao");
	}
	@Override
	public List<DownLoad> findAllDownload(DownLoad downLoad) throws SQLException {
		return downLoadDao.findAllDownload(downLoad);
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
		if(downLoad.getDoCreateTime() == null || downLoad.getDoDescrip().equals("") ||
			downLoad.getDoTitle().equals("") || downLoad.getuId().equals("") ||
			downLoad.getUrl() == null) {
			throw new DownloadException("输入参数错误");
		}
		downLoadDao.updateDownload(downLoad);
	}

	@Override
	public void insert(DownLoad downLoad) throws SQLException {
		if(downLoad.getDoCreateTime() == null || downLoad.getDoDescrip().equals("") ||
				downLoad.getDoTitle().equals("") || downLoad.getuId().equals("") ||
				downLoad.getUrl() == null) {
				throw new DownloadException("输入参数错误");
			}
		downLoadDao.insert(downLoad);
	}
}
