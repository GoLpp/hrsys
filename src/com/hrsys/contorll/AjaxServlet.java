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
			System.out.println("deptService�����ȡʧ��" + e.getMessage());
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
	 * @Description: ajax���depts
	 * @param @param resp
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
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
			System.out.println("ajaxʧ��" + e.getMessage());
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
