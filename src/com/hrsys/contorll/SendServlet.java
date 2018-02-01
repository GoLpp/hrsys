package com.hrsys.contorll;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/send")
public class SendServlet extends HttpServlet{
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
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
