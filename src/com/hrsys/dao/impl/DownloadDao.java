package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.IDownloadDao;
import com.hrsys.pojo.DownLoad;
import com.hrsys.utils.JdbcUtils;
/**
 * 
 * @ClassName: DownloadDao 
 * @Description: 下载中心实现类
 * @author GG Bone
 * @date 2018年1月31日 上午9:56:12 
 *
 */
public class DownloadDao implements IDownloadDao{

	@Override
	public List<DownLoad> findAllDownload(DownLoad downLoad) throws SQLException {
		String sql = "select *from t_download where downState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(DownLoad.class));
	}

	@Override
	public void removeDownload(DownLoad downLoad) throws SQLException {
		String sql = "update t_download set downState=0 where doId=?";
		JdbcUtils.getQueryRunner().update(sql, downLoad.getDoId());
	}

	@Override
	public void updateDownload(DownLoad downLoad) throws SQLException {
		String sql = "update t_download set doDescrip=?,doTitle=?,"
				+ "doCreateTime=?,url=?,uId=? where doId=?";
		JdbcUtils.getQueryRunner().update(sql, downLoad.getDoDescrip(),
				downLoad.getDoTitle(),
				downLoad.getDoCreateTime(),
				downLoad.getUrl(),
				downLoad.getuId(),
				downLoad.getDoId());
	}

	@Override
	public void insert(DownLoad downLoad) throws SQLException {
		String sql = "insert into t_download(doDescrip,doTitle,doCreateTime,url,uId) "
				+ "values(?,?,?,?,?)";
		JdbcUtils.getQueryRunner().update(sql, downLoad.getDoDescrip(),
				downLoad.getDoTitle(),
				downLoad.getDoCreateTime(),
				downLoad.getUrl(),
				downLoad.getuId());
	}

	@Override
	public DownLoad findDownloadById(DownLoad downLoad) throws SQLException {
		String sql = "select *from t_download where doId=? and downState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(DownLoad.class),downLoad.getDoId());
	}

	@Override
	public List<DownLoad> findDownloadByCondition(DownLoad downLoad) throws SQLException {
		String sql = "select *from t_download where doTitle like ? and downState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(DownLoad.class),"%"+downLoad.getDoTitle()+"%");
	}

}
