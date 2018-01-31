package com.hrsys.service;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Notice;

/**
 * 
 * @ClassName: INoticeService 
 * @Description: ����ҵ���߼���ӿ�
 * @author GG Bone
 * @date 2018��1��31�� ����6:53:25 
 *
 */
public interface INoticeService {
	/**
	 * 
	 * @Title: insert 
	 * @Description: �����ݿ������ӹ���
	 * @param @param notice
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void insert(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllNotice 
	 * @Description: �������ݿ��е����й��� 
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	List<Notice> findAllNotice() throws SQLException;
	
	/**
	 * 
	 * @Title: findNoticeByCondition 
	 * @Description: ͨ���������� 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Notice>    �������� 
	 * @throws
	 */
	List<Notice> findNoticeByCondition(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: findNoticeById 
	 * @Description: ͨ��id���� 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return Notice    �������� 
	 * @throws
	 */
	Notice findNoticeById(Notice notice) throws SQLException;
	/**
	 * 
	 * @Title: removeNotice 
	 * @Description: �Ƴ����� 
	 * @param @param notice
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void removeNotice(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: updateNotice 
	 * @Description: ���¹���
	 * @param @param notice
	 * @param @throws SQLException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	void updateNotice(Notice notice) throws SQLException;

}