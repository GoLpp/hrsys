package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.hrsys.dao.IJobDao;
import com.hrsys.pojo.Job;
import com.hrsys.utils.JdbcUtils;
/**
 * 
 * @ClassName: JobDao 
 * @Description: 职位数据访问实现类
 * @author GG Bone
 * @date 2018年1月31日 上午9:56:52 
 *
 */
public class JobDao implements IJobDao{

	@Override
	public void insert(Job job) throws SQLException {
		String sql = "insert into t_job(jName,jDes) values(?,?)";
		JdbcUtils.getQueryRunner().update(sql,job.getjName(),job.getjDes());
	}

	@Override
	public List<Job> findAllJob() throws SQLException {
		String sql = "select *from t_job where jState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(Job.class));
		
	}

	@Override
	public void removeJob(Job job) throws SQLException {
		String sql = "update t_job set jState=0 where jId=?";
		JdbcUtils.getQueryRunner().update(sql, job.getjId());
	}

	@Override
	public void updateJob(Job job) throws SQLException {
		String sql = "update t_job set jName=?,jDes=? where jId=?";
		JdbcUtils.getQueryRunner().update(sql, job.getjName(),job.getjDes(),job.getjId());
	}

	@Override
	public List<Job> findJobByConditon(Job job) throws SQLException {
		String sql = "select * from t_job where jName like ? and jState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanListHandler<>(Job.class),"%" + job.getjName() + "%");
	}

	@Override
	public Job findJobById(Job job) throws SQLException {
		String sql = "select *from t_job where jId=? and jState=1";
		return JdbcUtils.getQueryRunner().query(sql, new BeanHandler<>(Job.class),job.getjId());
				
	}

}
