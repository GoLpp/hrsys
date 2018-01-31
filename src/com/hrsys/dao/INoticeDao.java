package com.hrsys.dao;

import java.sql.SQLException;
import java.util.List;

import com.hrsys.pojo.Notice;
/**
 * 
 * @ClassName: INoticeDao 
 * @Description: 公告数据访问接口
 * @author GG Bone
 * @date 2018年1月30日 下午8:12:22 
 *
 */
public interface INoticeDao {
	/**
	 * 
	 * @Title: insert 
	 * @Description: 向数据库中添加公告
	 * @param @param notice
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void insert(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: findAllNotice 
	 * @Description: 查找数据库中的所有公告 
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	List<Notice> findAllNotice() throws SQLException;
	
	/**
	 * 
	 * @Title: findNoticeByCondition 
	 * @Description: 通过条件查找 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByCondition(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: findNoticeById 
	 * @Description: 通过id查找 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return Notice    返回类型 
	 * @throws
	 */
	Notice findNoticeById(Notice notice) throws SQLException;
	/**
	 * 
	 * @Title: removeNotice 
	 * @Description: 移除公告 
	 * @param @param notice
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void removeNotice(Notice notice) throws SQLException;
	
	/**
	 * 
	 * @Title: updateNotice 
	 * @Description: 更新公告
	 * @param @param notice
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	void updateNotice(Notice notice) throws SQLException;
}
