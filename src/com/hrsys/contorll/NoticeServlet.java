package com.hrsys.contorll;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrsys.pojo.Notice;
import com.hrsys.service.INoticeService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@WebServlet(urlPatterns="/notice")
public class NoticeServlet extends HttpServlet{
	private INoticeService noticeService = null;
	public NoticeServlet() {
		try {
			noticeService = ObjectUtils.getObject("noticeService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("notice�����װ�����ȡʧ��" + e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		String path = null;
		Notice notice = null;
		try {
			notice = ObjectWraperUtils.getObject(req, Notice.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println("�����װʧ��");
		}
		
		jumpDecide(req, resp, method, notice);
	}
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String method, Notice notice)
			throws ServletException, IOException {
		String path = null;
		if("findAllNotice".equals(method)) {
			findAllNotice(req, resp);
		}else if("findNoticeByCondition".equals(method)) {
			findNoticeByCondition(req, resp, notice);
		}else if("removeNotice".equals(method)) {
			removeNotice(req, resp, notice, path);
		}else if("updateNotice".equals(method)) {
			updateNotice(req, resp, notice);
		}else if("addNotice".equals(method)) {
			addNotice(req, resp, notice);
		}else if("previewNotice".equals(method)) {
			previewNotice(req, resp, notice);
		}
	}
	/**
	 * 
	 * @Title: previewNotice 
	 * @Description: Ԥ����
	 * @param @param req
	 * @param @param resp
	 * @param @param notice
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void previewNotice(HttpServletRequest req, HttpServletResponse resp, Notice notice)
			throws ServletException, IOException {
		String path;
		try {
			notice = noticeService.findNoticeById(notice);
			path = "WEB-INF/jsp/notice/previewNotice.jsp";
			req.setAttribute("notice", notice);
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "notice?method=findAllNotice";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: addNotice 
	 * @Description: ���һ������ 
	 * @param @param req
	 * @param @param resp
	 * @param @param notice
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void addNotice(HttpServletRequest req, HttpServletResponse resp, Notice notice)
			throws ServletException, IOException {
		String path;
		try {
			noticeService.insert(notice);
			path = "notice?method=findAllNotice";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "WEB-INF/jsp/notice/showAddNotice.jsp";
			jumpPage(req, resp, path);
		}
	}
	
	/**
	 * 
	 * @Title: updateNotice 
	 * @Description: ���¹���
	 * @param @param req
	 * @param @param resp
	 * @param @param notice
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void updateNotice(HttpServletRequest req, HttpServletResponse resp, Notice notice)
			throws ServletException, IOException {
		String path;
		try {
			noticeService.updateNotice(notice);
			path = "notice?method=findAllNotice";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "send?method=updateNoticeToJsp";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: removeNotice 
	 * @Description: �Ƴ����� 
	 * @param @param req
	 * @param @param resp
	 * @param @param notice
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void removeNotice(HttpServletRequest req, HttpServletResponse resp, Notice notice, String path)
			throws ServletException, IOException {
		try {
			noticeService.removeNotice(notice);
			path = "notice?method=findAllNotice";
		} catch (SQLException e) {
			System.out.println("ɾ��ʧ��" + e.getMessage());
		}finally{
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: findNoticeByCondition 
	 * @Description: ������ѯ����
	 * @param @param req
	 * @param @param resp
	 * @param @param notice
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void findNoticeByCondition(HttpServletRequest req, HttpServletResponse resp, Notice notice)
			throws ServletException, IOException {
		String path;
		try {
			List<Notice> notices = noticeService.findNoticeByCondition(notice);
			req.setAttribute("notices", notices);
			path = "WEB-INF/jsp/notice/notice.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "notice?method=findAllNotice";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: findAllNotice 
	 * @Description: �������еĹ��� 
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void findAllNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path;
		try {
			List<Notice> notices = noticeService.findAllNotice();
			req.setAttribute("notices", notices);
			path = "WEB-INF/jsp/notice/notice.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "404.html";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: ҳ����ת 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String path
			) throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
