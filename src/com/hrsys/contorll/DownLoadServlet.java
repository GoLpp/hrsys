package com.hrsys.contorll;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.hrsys.pojo.DownLoad;
import com.hrsys.pojo.User;
import com.hrsys.service.IDownloadService;
import com.hrsys.utils.ObjectUtils;
import com.hrsys.utils.ObjectWraperUtils;
import com.hrsys.utils.UpLoadUtils;

@WebServlet(urlPatterns="/down")
public class DownLoadServlet extends HttpServlet{
	private IDownloadService downloadService = null;
	public DownLoadServlet() {
		try {
			downloadService = ObjectUtils.getObject("downLoadService");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println("�������ķ�������ȡʧ��" + e.getMessage());
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getParameter("method");
		DownLoad downLoad = null;
		String path = null;
		try {
			downLoad = ObjectWraperUtils.getObject(req, DownLoad.class);
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
			System.out.println("�����װʧ��" + e.getMessage());
		}
		jumpDecide(req, resp, method, downLoad,path);
	}
	/**
	 * 
	 * @Title: jumpDecide 
	 * @Description: �жϷ���ִ�й���
	 * @param @param req
	 * @param @param resp
	 * @param @param method
	 * @param @param downLoad
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void jumpDecide(HttpServletRequest req, HttpServletResponse resp, String method, DownLoad downLoad, String path
			)
			throws ServletException, IOException {
		if("findAllDocument".equals(method)) {
			findAllDocument(req, resp, downLoad);
		}else if("upDocumentToJsp".equals(method)) {
			path = "WEB-INF/jsp/document/showAddDocument.jsp";
			jumpPage(req, resp, path);
		}else if("addDocument".equals(method)) {
			addDocument(req, resp, downLoad);
		}else if("findDocumentByCondition".equals(method)) {
			findDocumentByCondition(req, resp, downLoad);
		}else if("removeDocument".equals(method)) {
			removeDocument(req, resp, downLoad);
		}else if("updateDocument".equals(method)) {
			updateDocement(req, resp, downLoad);
		}else if("downLoad".equals(method)) {
			try {
				downLoad = downloadService.findDownloadById(downLoad);
				UpLoadUtils.downDocement(req, resp, downLoad);
				path = "down?method=findAllDocument";
				jumpPage(req, resp, path);
			} catch (SQLException e) {
				System.out.println("����ʧ��" + e.getMessage());
			}
		}
	}
	/**
	 * 
	 * @Title: updateDocement 
	 * @Description: �����ļ�
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws UnsupportedEncodingException
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void updateDocement(HttpServletRequest req, HttpServletResponse resp, DownLoad downLoad)
			throws UnsupportedEncodingException, ServletException, IOException {
		String path;
		User user = (User) req.getSession().getAttribute("user");
		String url=UpLoadUtils.upDocument(req, downLoad);
		DownLoad downLoad2 = null;
		try {
			downLoad2 = downloadService.findDownloadById(downLoad);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		if(user.getuId().intValue() == downLoad2.getuId().intValue()) {
			downLoad.setUrl(url);
			downLoad.setuId(user.getuId());
			try {
				downloadService.updateDownload(downLoad);
				path = "down?method=findAllDocument";
				jumpPage(req, resp, path);
			} catch (SQLException e) {
				path = "send?method=updateDocumentToJsp";
				jumpPage(req, resp, path);
			}
		}else{
			path = "down?method=findAllDocument";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: removeDocument 
	 * @Description: �Ƴ��ϴ����ļ�
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void removeDocument(HttpServletRequest req, HttpServletResponse resp, DownLoad downLoad)
			throws ServletException, IOException {
		String path;
		DownLoad downLoad2 = null;
		boolean statu = false;
		try {
			downLoad2 = downloadService.findDownloadById(downLoad);
			String url = downLoad2.getUrl();
			File file = new File(getServletContext().getRealPath("upload/") + url);
			statu = file.delete();
			downloadService.removeDownload(downLoad);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			path = "down?method=findAllDocument";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: findDocumentByCondition 
	 * @Description: ͨ�����������ļ�
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void findDocumentByCondition(HttpServletRequest req, HttpServletResponse resp, DownLoad downLoad)
			throws ServletException, IOException {
		String path;
		try {
			List<DownLoad> downLoads = downloadService.findDownloadByCondition(downLoad);
			req.setAttribute("documents", downLoads);
			path = "WEB-INF/jsp/document/document.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "down?method=findAllDocument";
			jumpPage(req, resp, path);
		}
	}
	/**
	 * 
	 * @Title: addDocument 
	 * @Description: �ϴ��ļ� 
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws UnsupportedEncodingException
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void addDocument(HttpServletRequest req, HttpServletResponse resp, DownLoad downLoad)
			throws UnsupportedEncodingException, ServletException, IOException {
		String path;
		String fileName = UpLoadUtils.upDocument(req,downLoad);
		downLoad.setUrl(fileName);
		User user = (User) req.getSession().getAttribute("user");
		downLoad.setuId(user.getuId());
		try {
			downloadService.insert(downLoad);
			path = "down?method=findAllDocument";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "down?method=upDocumentToJsp";
			jumpPage(req, resp, path);			
		}
	}
	/**
	 * 
	 * @Title: findAllDocument 
	 * @Description: �鿴�����ĵ�
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	private void findAllDocument(HttpServletRequest req, HttpServletResponse resp, DownLoad downLoad)
			throws ServletException, IOException {
		String path;
		try {
			List<DownLoad> downLoads = downloadService.findAllDownload();
			req.setAttribute("documents", downLoads);
			path = "WEB-INF/jsp/document/document.jsp";
			jumpPage(req, resp, path);
		} catch (SQLException e) {
			path = "WEB-INF/jsp/main.jsp";
			jumpPage(req, resp, path);
		}
	}
	
	/**
	 * 
	 * @Title: jumpPage 
	 * @Description: ��תҳ��
	 * @param @param req
	 * @param @param resp
	 * @param @param path
	 * @param @throws ServletException
	 * @param @throws IOException  ����˵�� 
	 * @return void    �������� 
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
