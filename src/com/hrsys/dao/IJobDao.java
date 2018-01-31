package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;
import com.hrsys.pojo.Job;
/**
 * 
 * @ClassName: IJobDao 
 * @Description: 职位的数据访问层接口 
 * @author GG Bone
 * @date 2018年1月30日 下午8:15:41 
 *
 */
public interface IJobDao {
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
	void removeJob(Integer jId) throws SQLException;
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
