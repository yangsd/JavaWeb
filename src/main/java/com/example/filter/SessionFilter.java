package com.example.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.constants.UrlConstant;
import com.example.constants.UserConstant;
import com.example.login.SingleOnline;

/**
 * 
 * @author sdyang
 * @date 2015年6月30日 上午10:06:57
 */
public class SessionFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain fc)
			throws IOException, ServletException {

		// 绑定本次请求
		HttpServletRequest request = (HttpServletRequest) servletRequest;

		HttpServletResponse response = (HttpServletResponse) servletResponse;

		// 静态文件不过滤
		String uri = request.getRequestURI();
		String context = "";
		if (uri.startsWith("/JavaWeb")) {
			context = uri.substring(8, uri.length()).toLowerCase();
		} else {
			System.out.println("非法URI：" + uri);
		}
		final boolean isSingleLogin = Boolean.valueOf(System
				.getProperty("isSingleLogin"));
		if (this.isStaticFile(context) || this.isNoProtected(context)) {
			fc.doFilter(request, response);
		} else if (request.getSession().getAttribute(UserConstant.USERINFO) == null) {
			// 如果是ajax请求，则返回nologin
			if (request.getHeader("x-requested-with") != null
					&& request.getHeader("x-requested-with").equalsIgnoreCase(
							"XMLHttpRequest")) {
				PrintWriter printWriter = response.getWriter();
				printWriter.print("gotoLogin");
				printWriter.flush();
				printWriter.close();
			} else {
				response.sendRedirect(request.getContextPath()
						+ UrlConstant.LOGIN);
			}
			return;
		} else if (isSingleLogin) {
			if (!SingleOnline.isSessionValid(request.getSession().getId())) {
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with")
								.equalsIgnoreCase("XMLHttpRequest")) {

					String result = "kickout";
					PrintWriter printWriter = response.getWriter();
					printWriter.print(result);
					printWriter.flush();
					printWriter.close();
				} else {
					response.sendRedirect(request.getContextPath()
							+ UrlConstant.LOGIN);
				}
			} else {
				fc.doFilter(request, response);
			}
		} else {
			fc.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

	private boolean isStaticFile(String context) {
		String[] suffixs = new String[] { ".css", ".js", ".jpg", ".gif", ".png" };
		for (String suffix : suffixs) {
			if (context.endsWith(suffix)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是不需要安全认证的url
	 * @author sdyang
	 * @date 2015年7月9日 下午3:53:37
	 * @param context
	 * @return
	 */
	private boolean isNoProtected(String context) {
		String[] urls = new String[] { UrlConstant.LOGIN,
				UrlConstant.LOGIN_CHECK, UrlConstant.RANDOMNUM };
		for (String url : urls) {
			if (url.equals(context) || context.startsWith("/login")) {
				return true;
			}
		}
		return false;
	}
}
