package com.hrsys.contorll;

import java.io.IOException;
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

import net.sf.json.JSONArray;
@WebServlet(urlPatterns="/jobAjax")
public class JobAjax extends HttpServlet{
	private IJobService jobService = null;
	public JobAjax() {
		try {
			jobService = ObjectUtils.getObject("jobService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		if("getJob".equals(method)) {
			try {
				resp.setCharacterEncoding("UTF-8");
				List<Job> jobs = jobService.findAllJob();
				JSONArray jobsArray = JSONArray.fromObject(jobs);
				resp.getWriter().print(jobsArray.toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
