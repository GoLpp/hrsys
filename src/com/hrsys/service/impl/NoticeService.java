package com.hrsys.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hrsys.dao.INoticeDao;
import com.hrsys.dao.IUserDao;
import com.hrsys.exception.NoticeServiceException;
import com.hrsys.pojo.Notice;
import com.hrsys.pojo.User;
import com.hrsys.service.INoticeService;
import com.hrsys.utils.ObjectUtils;

public class NoticeService implements INoticeService{

	private INoticeDao noticeDao = null;
	private IUserDao userDao = null;
	public NoticeService() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		noticeDao = ObjectUtils.getObject("noticeDao");
		userDao = ObjectUtils.getObject("userDao");
	}
	@Override
	public void insert(Notice notice) throws SQLException {
		if(notice.getnContent().equals("")
				|| notice.getnName().equals("")
				|| notice.getuId() == null) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.insert(notice);
	}

	@Override
	public List<Notice> findAllNotice() throws SQLException {
		List<Notice> notices = noticeDao.findAllNotice();
		List<Notice> returnNotices = new ArrayList<>();
		return addUserToNotice(notices, returnNotices);
	
	}

	@Override
	public List<Notice> findNoticeByCondition(Notice notice) throws SQLException {
		List<Notice> notices = noticeDao.findNoticeByCondition(notice);
		List<Notice> returnNotices = new ArrayList<>();
		return addUserToNotice(notices, returnNotices);
	}

	@Override
	public Notice findNoticeById(Notice notice) throws SQLException {
		if(null == notice.getnId()) {
			throw new NoticeServiceException("输入参数错误");
		}
		return noticeDao.findNoticeById(notice);
	}

	@Override
	public void removeNotice(Notice notice) throws SQLException {
		if(null == notice.getnId()) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.removeNotice(notice);
	}

	@Override
	public void updateNotice(Notice notice) throws SQLException {
		if(notice.getnContent() == null
				|| notice.getnName() == null
				|| notice.getnId() == null) {
			throw new NoticeServiceException("输入参数错误");
		}
		noticeDao.updateNotice(notice);
	}
	
	/**
	 * 
	 * @Title: addUserToNotice 
	 * @Description: 添加user到Notice
	 * @param @param notices
	 * @param @param returnNotices
	 * @param @throws SQLException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private List<Notice> addUserToNotice(List<Notice> notices, List<Notice> returnNotices) throws SQLException {
		User user = new User();
		for(Notice notice:notices) {
			user.setuId(notice.getuId());
			user = userDao.findAnyUserById(user);
			notice.setUser(user);
			returnNotices.add(notice);
		}
		return returnNotices;
	}
}
