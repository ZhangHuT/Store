package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;

public class LogonCheckFilter implements Filter{
	
	//检查用户是否登陆
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		User user = (User) request.getAttribute("USER_IN_SESSION");
		if(null==user||"".equals(user)) {
			resp.sendRedirect("/com.store.www/logon.jsp");
			return;
		}
		//放行
		chain.doFilter(req, resp);
	}
}
