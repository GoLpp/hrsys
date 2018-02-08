package com.hrsys.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.hrsys.pojo.DownLoad;

/**
 * 
 * @ClassName: UpLoadUtils 
 * @Description: �ļ����غ��ϴ�
 * @author GG Bone
 * @date 2018��2��6�� ����11:28:07 
 *
 */
public class UpLoadUtils {
	public UpLoadUtils() {
	}
	/**
	 * 
	 * @Title: upDocument 
	 * @Description: �ϴ��ļ�
	 * @param @param req
	 * @param @param downLoad
	 * @param @return
	 * @param @throws UnsupportedEncodingException  ����˵�� 
	 * @return String    �������� 
	 * @throws
	 */
	public static String upDocument(HttpServletRequest req, DownLoad downLoad) throws UnsupportedEncodingException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
		List<FileItem> parseRequest = null;
		try {
			 parseRequest = servletFileUpload.parseRequest(req);
		} catch (FileUploadException e) {
			System.out.println("�������ʧ��" + e.getMessage());
		}
		String fileName = null;
		for(FileItem fileItem:parseRequest) {
			if(fileItem.isFormField()) {
				if("doTitle".equals(fileItem.getFieldName())) {
					downLoad.setDoTitle(fileItem.getString("utf-8"));
				}else if("doDescrip".equals(fileItem.getFieldName())) {
					downLoad.setDoDescrip(fileItem.getString("utf-8"));
				}else if("doId".equals(fileItem.getFieldName())) {
					downLoad.setDoId(Integer.parseInt(fileItem.getString("utf-8")));
				}
			}else{
				try {
					fileName = fileItem.getName();
					File file = new File(req.getServletContext().getRealPath(fileName));
					if(file.exists()) {
						file.delete();
						fileItem.write(new File(req.getServletContext().getRealPath("/upload"),fileName));
					}else{
						fileItem.write(new File(req.getServletContext().getRealPath("/upload"),fileName));
					}
				} catch (Exception e) {
					System.out.println("�ļ��ϴ�ʧ��" + e.getMessage());
				}
			}
		}
		return fileName;
	}
	/**
	 * 
	 * @Title: downDocement 
	 * @Description: �����ļ� 
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws UnsupportedEncodingException  ����˵�� 
	 * @return void    �������� 
	 * @throws
	 */
	public static void downDocement(HttpServletRequest req, HttpServletResponse resp,DownLoad downLoad) throws UnsupportedEncodingException {
		String downFile = req.getServletContext().getRealPath(downLoad.getUrl());
		String fileName = downLoad.getUrl();
		byte[] bytes = fileName.getBytes("UTF-8");
		
		if (req.getHeader("user-agent").toLowerCase().contains("msie")) {
	        // IE
			fileName = URLEncoder.encode(fileName, "UTF-8");
		} else {
	        // ��IE
			fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
		}
		
		//fileName = new String(bytes, "ISO-8859-1");
		
		resp.setHeader("content-disposition", "attachment;filename=" + fileName);
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(downFile);
			OutputStream outputStream = resp.getOutputStream();
			int length = 0;
			byte[] buf = new byte[1024];
			while((length = inputStream.read(buf)) != -1) {
				outputStream.write(buf, 0, length);
			}
			outputStream.flush();
			outputStream.close();
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
