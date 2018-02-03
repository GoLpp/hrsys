package com.hrsys.contorll;

import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hrsys.pojo.Department;
import com.hrsys.service.IDepartmentService;
import com.hrsys.utils.ObjectUtils;
@WebServlet(urlPatterns="/ajax")
public class AjaxServlet extends HttpServlet{
	private IDepartmentService deptService = null;
	public AjaxServlet() {
		try {
			deptService = ObjectUtils.getObject("departmentService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("deptService�����ȡʧ��" + e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		String path = null;
		if("getDepts".equals(method)) {
			try {
				List<Department> depts = deptService.findAllDepartment();
				req.setAttribute("depts", depts);
				path = "WEB-INF/jsp/employee/employee.jsp";
				jumpPage(req, resp, path);
			} catch (SQLException e) {
				System.out.println("ajaxʧ��" + e.getMessage());
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
		doGet(req, resp);
	}
}