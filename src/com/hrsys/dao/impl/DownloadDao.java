package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IDownloadDao;
import com.hrsys.pojo.DownLoad;
/**
 * 
 * @ClassName: DownloadDao 
 * @Description: ��������ʵ����
 * @author GG Bone
 * @date 2018��1��31�� ����9:56:12 
 *
 */
public class DownloadDao implements IDownloadDao{

	@Override
	public List<DownLoad> findAllDownload(String infor) throws SQLException {
		return null;
	}

	@Override
	public void removeDownload(String infor) throws SQLException {
		
	}

	@Override
	public void updateDownload(DownLoad downLoad) throws SQLException {
		
	}

	@Override
	public void insert(DownLoad downLoad) throws SQLException {
		
	}

	@Override
	public DownLoad findDownloadById(DownLoad downLoad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DownLoad> findDownloadByCondition(DownLoad downLoad) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
