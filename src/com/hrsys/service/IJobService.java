package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Job;

/**
 * 
 * @ClassName: IJobService 
 * @Description: 职位业务逻辑层接口
 * @author GG Bone
 * @date 2018年1月31日 下午6:52:59 
 *
 */
public interface IJobService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加一个职位 
	 * @param @param job
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void insert(Job job) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllJob 
	 * @Description: 查找所有职位
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	List<Job> findAllJob() throws SQLException;
	
	/**
	 * 
	 * @Title: removeJob 
	 * @Description: 删除一个职位 
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void removeJob(Job job) throws SQLException;
	/**
	 * 
	 * @Title: findJobByConditon 
	 * @Description: 通过条件查找
	 * @param @param job
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Job>    返回类型 
	 * @throws
	 */
	List<Job> findJobByConditon(Job job) throws SQLException;	
	/**
	 * 
	 * @Title: findJobById 
	 * @Description: 通过id查找 
	 * @param @param job
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return Job    返回类型 
	 * @throws
	 */
	Job findJobById(Job job) throws SQLException;
	/**
	 * 
	 * @Title: updateJob 
	 * @Description: 更新职位信息
	 * @param @param job
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateJob(Job job) throws SQLException;

}
