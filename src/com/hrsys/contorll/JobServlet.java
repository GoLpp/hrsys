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

import com.hrsys.pojo.Job;
import com.hrsys.service.IJobService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@WebServlet(urlPatterns="/job")
public class JobServlet extends HttpServlet{
	private IJobService JobService = null;
	public JobServlet() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		JobService = ObjectUtils.getObject("jobService");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		String path = null;
		Job job = null;
		try {
			job = ObjectWraperUtils.getObject(req, Job.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			req.getRequestDispatcher("404.html").forward(req, resp);
		}
		
		jumpDecide(req, resp, method, job); 
	}
	/**
	 * 
	 * @Title: jumpDecide 
	 * @Description: 判断执行业务
	 * @param @param req
	 * @param @param resp
	 * @param @param method
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String method, Job job)
			throws ServletException, IOException {
		String path = null;
		if("findAllJob".equals(method)) {
			selectJob(req, resp);
		}else if("addJobToJsp".equals(method)) {
			path = "WEB-INF/jsp/job/showAddJob.jsp";
			jumpPage(req, resp, path);
		}else if("findJobByCondition".equals(method)) {
			findJobByConditon(req, resp, job, path);
		}else if("removeJob".equals(method)) {
			removeJob(req, resp, job, path);
		}else if("updateJob".equals(method)) {
			updateJob(req, resp, job);
		}else if("addJob".equals(method)) {
			try {
				JobService.insert(job);
				path = "job?method=findAllJob";
			} catch (SQLException e) {
				e.printStackTrace();
				path = "job?method=addJobToJsp";
				jumpPage(req, resp, path);
			}
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: updateJob 
	 * @Description: 更新职位 
	 * @param @param req
	 * @param @param resp
	 * @param @param job
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void updateJob(HttpServletRequest req, HttpServletResponse resp, Job job)
			throws ServletException, IOException {
		String path;
		try {
			JobService.updateJob(job);
			path = "job?method=findAllJob";
		} catch (SQLException e) {
			e.printStackTrace();
			path = "send?method=updateJobToJsp";
			jumpPage(req, resp, path);
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: removeJob 
	 * @Description: 删除一个用户
	 * @param @param req
	 * @param @param resp
	 * @param @param job
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void removeJob(HttpServletRequest req, HttpServletResponse resp, Job job, String path)
			throws ServletException, IOException {
		try {
			JobService.removeJob(job);
			path = "job?method=findAllJob";
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: findJobByConditon 
	 * @Description: 查找职位 
	 * @param @param req
	 * @param @param resp
	 * @param @param job
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void findJobByConditon(HttpServletRequest req, HttpServletResponse resp, Job job, String path)
			throws ServletException, IOException {
		try {
			List<Job> jobs = JobService.findJobByConditon(job);
			req.setAttribute("jobs", jobs);
			path = "WEB-INF/jsp/job/job.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			jumpPage(req, resp, "job?method=findAllJob");
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: selectJob 
	 * @Description: 查询所有职位 
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void selectJob(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path;
		try {
			List<Job> jobs = JobService.findAllJob();
			req.setAttribute("jobs", jobs);
			path = "WEB-INF/jsp/job/job.jsp";
		} catch (SQLException e) {
			path = "/send";
			jumpPage(req, resp, path);
		}
		jumpPage(req, resp, path);
	}
	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 * @Title: jumpPage 
	 * @Description: 跳转页面
	 * @param @param req
	 * @param @param resp
	 * @param @param path  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
			req.getRequestDispatcher(path).forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
