package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements javax.servlet.Filter{
	
	public HelloFilter() {
		System.out.println("执行构造器");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter.init()");
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("处理数据");
		//放行
		chain.doFilter(req, resp);
	}
}
