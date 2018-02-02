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
import com.hrsys.service.IJobService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@WebServlet(urlPatterns="/send")
public class SendServlet extends HttpServlet{
	private IJobService jobService = null;
	public SendServlet() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		jobService = ObjectUtils.getObject("jobService");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("method");
		jumpPage(req, resp, name);
	}

	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String name)
			throws ServletException, IOException {
		if("top".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/top.jsp").forward(req, resp);
		}else if("right".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/right.jsp").forward(req, resp);
		}else if("left".equals(name)) {
			req.getRequestDispatcher("/WEB-INF/jsp/left.jsp").forward(req, resp);
		}else if("updateJobToJsp".equals(name)) {
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
	}
	
	private void jumpPage1(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
