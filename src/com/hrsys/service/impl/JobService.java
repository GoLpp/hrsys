package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.dao.IJobDao;
import com.hrsys.exception.JobServiceException;
import com.hrsys.pojo.Job;
import com.hrsys.service.IJobService;
import com.hrsys.utils.ObjectUtils;

public class JobService implements IJobService{

	private IJobDao jobDao = null;
	public JobService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		jobDao = ObjectUtils.getObject("jobDao");
	}
	@Override
	public void insert(Job job) throws SQLException {
		if(job.getjDes().equals("") || job.getjName().equals("")) {
			throw new JobServiceException("输入参数错误");
		}
		jobDao.insert(job);
	}

	@Override
	public List<Job> findAllJob() throws SQLException {
		return jobDao.findAllJob();
	}

	@Override
	public void removeJob(Job job) throws SQLException {
		if(null == job.getjId()) {
			throw new JobServiceException("输入参数错误");
		}
		jobDao.removeJob(job);
	}

	@Override
	public List<Job> findJobByConditon(Job job) throws SQLException {
		return jobDao.findJobByConditon(job);
	}

	@Override
	public Job findJobById(Job job) throws SQLException {
		if(null == job.getjId()) {
			throw new JobServiceException("输入参数错误");
		}
		return jobDao.findJobById(job);
	}

	@Override
	public void updateJob(Job job) throws SQLException {
		if(job.getjDes().equals("") || job.getjName().equals("")) {
			throw new JobServiceException("输入参数错误");
		}
		jobDao.updateJob(job);
	}
}
