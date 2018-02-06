package com.hrsys.contorll;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrsys.pojo.Department;
import com.hrsys.pojo.Job;
import com.hrsys.service.IDepartmentService;
import com.hrsys.service.IJobService;
import com.hrsys.utils.ObjectUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
@WebServlet(urlPatterns="/deptAjax")
public class AjaxServlet extends HttpServlet{
	private IDepartmentService deptService = null;
	public AjaxServlet() {
		try {
			deptService = ObjectUtils.getObject("departmentService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("deptService对象获取失败" + e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		String path = null;
		if("getDepts".equals(method)) {
			getDepts(resp);
		}
	}
	/**
	 * 
	 * @Title: getDepts 
	 * @Description: ajax获得depts
	 * @param @param resp
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void getDepts(HttpServletResponse resp) throws IOException {
		try {
			resp.setContentType("text/html;charset=uft8");
			resp.setCharacterEncoding("UTF-8");
			List<Department> departments = deptService.findAllDepartment();
			JSONArray depts = JSONArray.fromObject(departments);
			resp.getWriter().print(depts.toString());
			resp.getWriter().flush();
			resp.getWriter().close();
		} catch (SQLException e) {
			System.out.println("ajax失败" + e.getMessage());
		}
	}
	
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: 跳转页面 
	 * @param @param req
	 * @param @param resp
	 * @param @param path  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException | IOException e) {
			System.out.println("跳转失败" + e.getMessage());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
