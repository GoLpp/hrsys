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
			System.out.println("Ա����������ȡʧ��" + e.getMessage());
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
			System.out.println("�����װʧ��");
		}
		
		if("findAllEmployee".equals(method)) {
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
	}
	
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: ��תҳ��
	 * @param @param req
	 * @param @param resp
	 * @param @param path  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void jumpPage(HttpServletRequest req, HttpServletResponse resp, String path) {
		try {
			req.getRequestDispatcher(path).forward(req, resp);
		} catch (ServletException | IOException e) {
			System.out.println("��תʧ��" + e.getMessage());
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(null, resp);
	}
}
