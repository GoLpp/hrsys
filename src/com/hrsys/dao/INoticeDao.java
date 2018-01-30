package com.hrsys.dao;

import java.sql.SQLException;
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
	void findAllNotice() throws SQLException;
}
