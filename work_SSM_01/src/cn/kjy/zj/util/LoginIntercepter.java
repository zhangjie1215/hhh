package cn.kjy.zj.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginIntercepter extends HandlerInterceptorAdapter {
	private static String [] arr={
		"uc/cl"
	};
	public boolean checkUrl(String url){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].equals(url)){
				return true;
			}
		}
		if(url!=null&&!"".equals(url)&&url.endsWith(".js")){
			return true;
		}
		return false;
	}
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
			//System.out.println("执行业务方法之前的操作");
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("u");
			String uri=request.getRequestURI();
			//System.out.println(uri);
			String contextpath=request.getContextPath();
			//System.out.println(contextpath);
			String url=uri.substring(contextpath.length()+1, uri.length());
			if(obj==null){
				if(this.checkUrl(url)){
					return true;
				}
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//System.out.println("执行业务方法之后的操作");
	}
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//System.out.println("请求结束之后的操作");
	}
}
