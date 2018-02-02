package com.hrsys.contorll;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrsys.pojo.Job;
import com.hrsys.pojo.Notice;
import com.hrsys.service.IJobService;
import com.hrsys.service.INoticeService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@WebServlet(urlPatterns="/send")
public class SendServlet extends HttpServlet{
	private IJobService jobService = null;
	private INoticeService noticeService = null;
	public SendServlet() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		jobService = ObjectUtils.getObject("jobService");
		noticeService = ObjectUtils.getObject("noticeService");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("method");
		jumpDecide(req, resp, name);
	}

	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String name)
			throws ServletException, IOException {
		if("top".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/top.jsp").forward(req, resp);
		}else if("right".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/right.jsp").forward(req, resp);
		}else if("left".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(req, resp);
		}else if("updateJobToJsp".equals(name)) {
			updateJobToJsp(req, resp);
		}else if("updateNoticeToJsp".equals(name)) {
			updateNoticeToJsp(req, resp);
		}else if("addNoticeToJsp".equals(name)) {
			String path = "WEB-INF/jsp/notice/showAddNotice.jsp";
			jumpPage1(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: updateNoticeToJsp 
	 * @Description: ��ת�����¹����jsp
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void updateNoticeToJsp(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Notice notice = null;
		String path = null;
		try {
			notice = ObjectWraperUtils.getObject(req, Notice.class);
			Notice notice2 = noticeService.findNoticeById(notice);
			req.setAttribute("notice", notice2);
			path = "WEB-INF/jsp/notice/showUpdateNotice.jsp";
			jumpPage1(req, resp, path);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
			path = "notice?method=findAllNotice";
			jumpPage1(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: updateJobToJsp 
	 * @Description: ��ת������ְλҳ�� 
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void updateJobToJsp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Job job = null;
		String path = null;
		try {
			job = ObjectWraperUtils.getObject(req, Job.class);
			Job job2 = jobService.findJobById(job);
			req.setAttribute("job", job2);
			path = "WEB-INF/jsp/job/showUpdateJob.jsp";
			jumpPage1(req, resp, path);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
			path = "job?method=findAllJob";
			jumpPage1(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: jumpPage1 
	 * @Description: ��תҳ��
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	
	private void jumpPage1(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
