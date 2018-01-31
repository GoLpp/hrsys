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
	 * @Title: findNoticeByLikeTile 
	 * @Description: 通过主题模糊查询公告信息 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByLikeTile(Notice notice) throws SQLException;
	/**
	 * 
	 * @Title: findNoticeByLikeContent 
	 * @Description: 通过内容模糊查询公告信息 
	 * @param @param notice
	 * @param @return
	 * @param @throws SQLException  参数说明 
	 * @return List<Notice>    返回类型 
	 * @throws
	 */
	List<Notice> findNoticeByLikeContent(Notice notice) throws SQLException;
	
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
