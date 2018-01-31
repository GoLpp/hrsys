package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Job;

/**
 * 
 * @ClassName: IJobService 
 * @Description: ְλҵ���߼���ӿ�
 * @author GG Bone
 * @date 2018��1��31�� ����6:52:59 
 *
 */
public interface IJobService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: ���һ��ְλ 
	 * @param @param job
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insert(Job job) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllJob 
	 * @Description: ��������ְλ
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	List<Job> findAllJob() throws SQLException;
	
	/**
	 * 
	 * @Title: removeJob 
	 * @Description: ɾ��һ��ְλ 
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeJob(Job job) throws SQLException;
	/**
	 * 
	 * @Title: findJobByConditon 
	 * @Description: ͨ����������
	 * @param @param job
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Job>    �������� 
	 * @throws
	 */
	List<Job> findJobByConditon(Job job) throws SQLException;	
	/**
	 * 
	 * @Title: findJobById 
	 * @Description: ͨ��id���� 
	 * @param @param job
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return Job    �������� 
	 * @throws
	 */
	Job findJobById(Job job) throws SQLException;
	/**
	 * 
	 * @Title: updateJob 
	 * @Description: ����ְλ��Ϣ
	 * @param @param job
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void updateJob(Job job) throws SQLException;

}
