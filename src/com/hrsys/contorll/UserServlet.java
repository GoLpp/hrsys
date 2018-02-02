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

import com.hrsys.exception.UserServiceException;
import com.hrsys.pojo.User;
import com.hrsys.service.IUserService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
@WebServlet(urlPatterns="/user")
public class UserServlet extends HttpServlet{
	private IUserService userService = null;
	
	public UserServlet() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		userService = ObjectUtils.getObject("userService");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("method");
		User user = null;
		try {
			user = ObjectWraperUtils.getObject(req, User.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		jumpDecide(req, resp, parameter, user);
	}
	/**
	 * 
	 * @Title: jumpDecide 
	 * @Description: 判断跳转到哪个页面 
	 * @param @param req
	 * @param @param resp
	 * @param @param parameter
	 * @param @param user
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String parameter, User user)
			throws ServletException, IOException {
		String path = null;
		if(parameter.equals("verify")) {
			login(req, resp, user);
		}else if("exit".equals(parameter)) {
			req.getSession().removeAttribute("user");
			path = "WEB-INF/jsp/loginForm.jsp"; 
			jumpPage(path, req, resp); 
		}else if("findAllUser".equals(parameter)) {
			findAllUser(req, resp, path);
		}else if("addUserToJsp".equals(parameter)){
			path = "WEB-INF/jsp/user/showAddUser.jsp";
			jumpPage(path, req, resp);
		}else if("updateToJsp".equals(parameter)) {
			updateToJsp(req, resp, user);
		}else if("selectUser".equals(parameter)) {
			selectUser(req, resp, path);
		}else if("removeUser".equals(parameter)) {
			removeUser(req, resp, path);
		}else if("updateUser".equals(parameter)) {
			updateUser(req, resp, path);
		}else if("addUser".equals(parameter)) {
			addUser(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: addUser 
	 * @Description: 添加用户 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void addUser(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		User user2 = null;
		try {
			user2 = ObjectWraperUtils.getObject(req, User.class);
			userService.insert(user2);
			path = "user?method=findAllUser";
		} catch (InstantiationException | UserServiceException | IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
		jumpPage(path, req, resp);
	}
	/**
	 * 
	 * @Title: updateToJsp 
	 * @Description: 跳转到修改页面 
	 * @param @param req
	 * @param @param resp
	 * @param @param user
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void updateToJsp(HttpServletRequest req, HttpServletResponse resp, User user)
			throws ServletException, IOException {
		String path;
		path = "WEB-INF/jsp/user/showUpdateUser.jsp";
		try {
			user = userService.findUserById(user);
			req.setAttribute("user", user);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		jumpPage(path, req, resp);
	}
	
	/**
	 * 
	 * @Title: updateUser 
	 * @Description: 更新用户信息 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void updateUser(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		User user2 = null;
		try {
			user2 = ObjectWraperUtils.getObject(req, User.class);
			User user = (User) req.getSession().getAttribute("user");
			if(user.getuId().intValue() == user2.getuId().intValue()) {
				userService.updateUser(user2);
				path = "WEB-INF/jsp/loginForm.jsp";
				jumpPage(path, req, resp);
			}else{
				userService.updateUser(user2);
				path = "user?method=findAllUser";
				jumpPage(path, req, resp);
			}
		} catch (InstantiationException | UserServiceException | IllegalAccessException | InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: removeUser 
	 * @Description: 删除用户 
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void removeUser(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		User user2 = null;
		try {
			user2 = ObjectWraperUtils.getObject(req, User.class);
			User user = (User) req.getSession().getAttribute("user");
			if(user.getuId().intValue() == user2.getuId().intValue()) {
				jumpPage("user?method=findAllUser", req, resp);
			}else{
				userService.removeUser(user2);
				path = "user?method=findAllUser";
				jumpPage(path, req, resp);
			}
		} catch (InstantiationException | IllegalAccessException | UserServiceException |InvocationTargetException | SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @Title: selectUser 
	 * @Description: 通过条件模糊查找用户
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void selectUser(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		User user2 = null;
		try {
			user2 = ObjectWraperUtils.getObject(req, User.class);
			 List<User> users = userService.findUserByCondition(user2);
			 System.out.println(users);
			 req.setAttribute("users", users);
			 path = "WEB-INF/jsp/user/user.jsp";
		}catch (Exception e) {
			e.printStackTrace();
		}
		jumpPage(path, req, resp);
	}
	/**
	 * 
	 * @Title: findAllUser 
	 * @Description: 查找用户并跳转
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void findAllUser(HttpServletRequest req, HttpServletResponse resp, String path)
			throws ServletException, IOException {
		try {
			List<User> users = userService.findAllUser();
			req.setAttribute("users", users);
			path = "WEB-INF/jsp/user/user.jsp";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jumpPage(path, req, resp);
	}
	
	/**
	 * 
	 * @Title: login 
	 * @Description: 登录验证
	 * @param @param req
	 * @param @param resp
	 * @param @param user
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp, User user)
			throws ServletException, IOException {
		String path;
		User user2 = null;
		try {
			user2 = userService.findUserByLogNameAndPwd(user);
		} catch (SQLException  | UserServiceException e) {
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
		req.getSession().setAttribute("user", user2);
		path = "WEB-INF/jsp/main.jsp";
		jumpPage(path,req, resp);
	}
	
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: 跳转页面 
	 * @param @param req
	 * @param @param resp
	 * @param @throws ServletException
	 * @param @throws IOException  参数说明 
	 * @return void    返回类型 
	 * @throws
	 */
	private void jumpPage(String path, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
