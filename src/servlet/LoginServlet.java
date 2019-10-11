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
//注册页面
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static IUserDao Userdao;

	//处理账号注册操作
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("username");
		if(Userdao.get(name)!=null) {
			req.setAttribute("erroMsg", "该用户名已存在，请重新填入");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return ;
		}
		User user=new User();
		String password=req.getParameter("password");
		user.setName(name);
		user.setPassword(password);
		Userdao.save(user);
		resp.sendRedirect("/com.store.www/logon.jsp");
	}

	//初始化
	public void init() throws ServletException {
		Userdao=new UserDaoImpl();
	}
	
}
