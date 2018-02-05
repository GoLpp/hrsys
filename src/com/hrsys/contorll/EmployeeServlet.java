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

import com.hrsys.exception.EmployeeException;
import com.hrsys.pojo.Employee;
import com.hrsys.service.IEmployeeService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;

@WebServlet(urlPatterns="/emps")
public class EmployeeServlet extends HttpServlet{
	private IEmployeeService employeeService = null;
	public EmployeeServlet() {
		try {
			employeeService = ObjectUtils.getObject("employeeService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("员工服务对象获取失败" + e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		Employee employ = null;
		String path = null;
		try {
			employ = ObjectWraperUtils.getObject(req, Employee.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println("对象封装失败");
		}
		
		jumpDecide(req, resp, method,employ);
	}
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String method, Employee employee) {
		String path = null;
		if("findAllEmployee".equals(method)) {
			findAllEmployee(req, resp);
		}else if("selectByCondition".equals(method)) {
			selectByCondition(req, resp, employee); 
		}else if("removeEmployee".equals(method)) {
			removeEmployee(req, resp, employee, path);
		}else if("updateEmployee".equals(method)) {
			updateEmployee(req, resp, employee);
		}else if("addEmployee".equals(method)) {
			try {
				employeeService.insertEmployee(employee);
				path = "emps?method=findAllEmployee";
				jumpPage(req, resp, path);
			} catch (SQLException | EmployeeException e) {
				path = "send?method=addEmployeeToJsp";
				jumpPage(req, resp, path);
				e.printStackTrace();
			}
		}
	}
	/**
	 * 
	 * @Title: updateEmployee 
	 * @Description: 更新员工信息
	 * @param @param req
	 * @param @param resp
	 * @param @param employee  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void updateEmployee(HttpServletRequest req, HttpServletResponse resp, Employee employee) {
		String path;
		try {
			employeeService.update(employee);
			path = "emps?method=findAllEmployee";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} 
	/**
	 * 
	 * @Title: removeEmployee 
	 * @Description: 移除员工
	 * @param @param req
	 * @param @param resp
	 * @param @param employee
	 * @param @param path  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void removeEmployee(HttpServletRequest req, HttpServletResponse resp, Employee employee, String path) {
		try {
			employeeService.removeEmployee(employee);
			path = "emps?method=findAllEmployee";
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: selectByCondition 
	 * @Description: 按条件查询员工
	 * @param @param req
	 * @param @param resp
	 * @param @param employee  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void selectByCondition(HttpServletRequest req, HttpServletResponse resp, Employee employee) {
		String path;
		try {
			List<Employee> employees = employeeService.findEmployeeByCondition(employee);
			req.setAttribute("employees", employees);
			path = "WEB-INF/jsp/employee/employee.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "emps/method=findAllEmployee";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: findAllEmployee 
	 * @Description: 查找所有的用户
	 * @param @param req
	 * @param @param resp  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void findAllEmployee(HttpServletRequest req, HttpServletResponse resp) {
		String path;
		try {
			List<Employee> employees = employeeService.findAllEmployee();
			req.setAttribute("employees", employees);
			path = "WEB-INF/jsp/employee/employee.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "WEB-INF/jsp/main.jsp";
			jumpPage(req, resp, path);
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
