package com.hrsys.contorll;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrsys.pojo.Department;
import com.hrsys.service.IDepartmentService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@MultipartConfig
@WebServlet(urlPatterns="/dept")
public class DeptServlet extends HttpServlet{
	private IDepartmentService deptService = null;
	public DeptServlet() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		deptService = ObjectUtils.getObject("departmentService");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		String path = null;
		Department dept = null;
		try {
			dept = ObjectWraperUtils.getObject(req, Department.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("对象封装问题");
		}
		jumpDecide(req, resp, method, path, dept);
	}
	/**
	 * 
	 * @Title: jumpDecide 
	 * @Description: 执行服务 
	 * @param @param req
	 * @param @param resp
	 * @param @param method
	 * @param @param path
	 * @param @throws IOException
	 * @param @throws ServletException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String method, String path, Department dept)
			throws IOException, ServletException {
		if("selectDept".equals(method)) {
			selectDept(req, resp, path);
		}else if("findDept".equals(method)) {
			findDept(req, resp, path, dept);
		}else if("updateDeptToJsp".equals(method)) {
			toUpdateJsp(req, resp, dept);
		}else if("removeDept".equals(method)) {
			removeDept(req, resp, path, dept);
		}else if("addDeptToJsp".equals(method)) {
			path = "WEB-INF/jsp/dept/showAddDept.jsp";
			jumpPage(req, resp, path);
		}else if("addDept".equals(method)) {
			addDept(req, resp, dept);
		}else if("updateDept".equals(method)) {
			updateDept(req, resp, dept);
		}
	}
	/**
	 * 
	 * @Title: updateDept 
	 * @Description: 更新部门 
	 * @param @param req
	 * @param @param resp
	 * @param @param dept
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void updateDept(HttpServletRequest req, HttpServletResponse resp, Department dept)
			throws ServletException, IOException {
		String path;
		try {
			deptService.updateDepartment(dept);
			path = "dept?method=selectDept";
		} catch (SQLException e) {
			e.printStackTrace();
			path = "WEB-INF/jsp/dept/showUpdateDept.jsp";
			jumpPage(req, resp, path);
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: ToUpdateJsp 
	 * @Description: 更新转发
	 * @param @param req
	 * @param @param resp
	 * @param @param dept
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void toUpdateJsp(HttpServletRequest req, HttpServletResponse resp, Department dept)
			throws ServletException, IOException {
		String path;
		path = "WEB-INF/jsp/dept/showUpdateDept.jsp";
		try {
			dept = deptService.findDeptById(dept);
			req.setAttribute("dept", dept);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: addDept 
	 * @Description: 添加一个部门 
	 * @param @param req
	 * @param @param resp
	 * @param @param dept
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void addDept(HttpServletRequest req, HttpServletResponse resp, Department dept)
			throws ServletException, IOException {
		String path;
		try {
			deptService.insertDepartment(dept);
			path = "dept?method=selectDept";
		} catch (SQLException e) {
			path = "WEB-INF/jsp/dept/showAddDept.jsp";
			jumpPage(req, resp, path);
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: removeDept 
	 * @Description: 移除部门 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @param dept
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void removeDept(HttpServletRequest req, HttpServletResponse resp, String path, Department dept)
			throws ServletException, IOException {
		try {
			deptService.removeDepartment(dept);
			path = "dept?method=selectDept";
		} catch (SQLException e) {
			jumpPage(req, resp, path);
		}
		jumpPage(req, resp, path);
	}
	
	/**
	 * 
	 * @Title: findDept 
	 * @Description: 模糊查找部门 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @param dept
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void findDept(HttpServletRequest req, HttpServletResponse resp, String path, Department dept)
			throws ServletException, IOException {
		try {
			List<Department> depts = deptService.findDeptByCondition(dept);
			req.setAttribute("depts", depts);
			path = "WEB-INF/jsp/dept/dept.jsp";
		} catch (SQLException e) {
			jumpPage(req, resp, "dept?method=selectDept");
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: selectDept 
	 * @Description: 查询所有部门 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws IOException
	 * @param @throws ServletException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void selectDept(HttpServletRequest req, HttpServletResponse resp, String path)
			throws IOException, ServletException {
		try {
			List<Department> depts = deptService.findAllDepartment();
			req.setAttribute("depts", depts);
			path = "WEB-INF/jsp/dept/dept.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
			resp.sendRedirect("404.html");
		}
		jumpPage(req, resp, path);
	}
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: 转发跳转页面 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
