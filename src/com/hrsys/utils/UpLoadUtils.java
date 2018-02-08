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
 * @Description: 文件下载和上传
 * @author GG Bone
 * @date 2018年2月6日 上午11:28:07 
 *
 */
public class UpLoadUtils {
	public UpLoadUtils() {
	}
	/**
	 * 
	 * @Title: upDocument 
	 * @Description: 上传文件
	 * @param @param req
	 * @param @param downLoad
	 * @param @return
	 * @param @throws UnsupportedEncodingException  参数说明 
	 * @return String    返回类型 
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
			System.out.println("请求解析失败" + e.getMessage());
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
					System.out.println("文件上传失败" + e.getMessage());
				}
			}
		}
		return fileName;
	}
	/**
	 * 
	 * @Title: downDocement 
	 * @Description: 下载文件 
	 * @param @param req
	 * @param @param resp
	 * @param @param downLoad
	 * @param @throws UnsupportedEncodingException  参数说明 
	 * @return void    返回类型 
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
	        // 非IE
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
