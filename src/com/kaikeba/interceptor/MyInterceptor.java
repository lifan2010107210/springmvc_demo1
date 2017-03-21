package com.kaikeba.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 在handler方法之前去执行的
	 * 返回值:
	 * true:正常执行下面的代码(handler), false:就此结束
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("之前...");
		return true;
	}

	/**
	 * 在handler方法之后, 在视图渲染之前去执行的
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("之后...");

	}

	/**
	 * 在整个视图都渲染完毕之后, 做一些资源的回收
	 */
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("回收...");

	}

}
