package com.hrsys.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IJobDao;
import com.hrsys.pojo.Job;
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
		
	}

	@Override
	public List<Job> findAllJob() throws SQLException {
		return null;
	}

	@Override
	public void removeJob(Integer jId) throws SQLException {
		
	}

	@Override
	public List<Job> findJobByLikeName(String name) throws SQLException {
		return null;
	}

	@Override
	public void updateJob(Job job) throws SQLException {
		
	}

}
