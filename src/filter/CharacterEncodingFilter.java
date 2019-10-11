package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//字符编码过滤器
public class CharacterEncodingFilter implements javax.servlet.Filter{
	
	private String encoding=null;
	private String content=null;
	private Boolean forceEncoding=false;
	
	public void init(FilterConfig filterConfig) throws ServletException {
		encoding=filterConfig.getInitParameter("encoding");
		content=filterConfig.getInitParameter("content-type");
		forceEncoding=Boolean.valueOf(filterConfig.getInitParameter("force"));
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		
		//设置编码
		//1.应用中没有编码并且我自己设置了编码
		//2.应用中已经存在编码了，但是依然要使用我自己的编码：强制使用	
		 //只有当读取的信息不为空时，才能够使用信息
		if((hasLength(encoding)||hasLength(content))&&
				(req.getCharacterEncoding()==null||forceEncoding)) {
			//防止编码写的当以，写入文件中，可随时更改
			req.setCharacterEncoding(encoding);
			resp.setContentType(content);			
		}else {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
		}
		//放行
		chain.doFilter(req, resp);
	}
	
	//判断字符串是否为空
	private boolean hasLength(String str) {
		if(null==str||"".equals(str.trim())) {
			return false;
		}
		return true;
	}
}
