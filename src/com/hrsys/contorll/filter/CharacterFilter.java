package com.hrsys.contorll.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter(urlPatterns="/*")
public class CharacterFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		HttpServletResponse response2 = (HttpServletResponse) response;
		response2.setContentType("text/html;charset=uft-8");
		
		HttpServletRequest req = (HttpServletRequest) Proxy.newProxyInstance(HttpServletRequest.class.getClassLoader(),
				new Class[]{HttpServletRequest.class},
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						String sendMethod = request2.getMethod();
						String methodName = method.getName();
						if("getParameter".equals(methodName)) {
							if("GET".equalsIgnoreCase(sendMethod)) {
								String infor = (String) method.invoke(request2, args);
								return infor;
							}else if("POST".equalsIgnoreCase(sendMethod)) {
								request2.setCharacterEncoding("UTF-8");
								return method.invoke(request2, args);
							}
						}
						return method.invoke(request2, args);
					}
				});
		chain.doFilter(req, response2);
	}
	
	@Override
	public void destroy() {
	
	}
}
