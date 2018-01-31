package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Notice;
/**
 * 
 * @ClassName: INoticeDao 
 * @Description: �������ݷ��ʽӿ�
 * @author GG Bone
 * @date 2018��1��30�� ����8:12:22 
 *
 */
public interface INoticeDao {
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
	 * @Title: findNoticeByLikeTile 
	 * @Description: ͨ������ģ����ѯ������Ϣ 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Notice>    �������� 
	 * @throws
	 */
	List<Notice> findNoticeByLikeTile(Notice notice) throws SQLException;
	/**
	 * 
	 * @Title: findNoticeByLikeContent 
	 * @Description: ͨ������ģ����ѯ������Ϣ 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  ����˵�� 
	 * @return List<Notice>    �������� 
	 * @throws
	 */
	List<Notice> findNoticeByLikeContent(Notice notice) throws SQLException;
	
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