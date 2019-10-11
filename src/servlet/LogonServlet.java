package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IUserDao;
import dao.impl.UserDaoImpl;
import domain.User;

//登陆
@WebServlet("/logon")
public class LogonServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static IUserDao Userdao=null;
	
	//处理请求
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("utf-8");
		//resp.setContentType("text/html;charset=utf-8");
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=Userdao.get(username);
		System.out.println(username+password);
		System.out.println(user);
		//验证码检查
		
		//当输入的账号不正确时
		if(null==user) {
			req.setAttribute("erroMsg", "没有该账号，请注册一个账号");
			req.getRequestDispatcher("/logon.jsp").forward(req, resp);
			return;
		}
		//验证密码是否正确
		if(!user.getPassword().equals(password)) {
			req.setAttribute("erroMsg", "账号或密码错误");
			req.getRequestDispatcher("/logon.jsp").forward(req, resp);
			return;
		}
		
		req.getRequestDispatcher("/shop").forward(req, resp);
	}
	
	//初始化
	public void init() throws ServletException {
		Userdao=new UserDaoImpl();
	}
	
}
