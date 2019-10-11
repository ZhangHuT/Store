package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStoreDao;
import dao.impl.StoreDaoImpl;
import domain.Store;

//购物列表
@WebServlet("/shop")
public class ShopServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static IStoreDao Storedao=null;
	//显示所有的商品
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Store> list = Storedao.list();
		req.getSession().setAttribute("Store_IN_SESSION", list);
		req.getRequestDispatcher("/store.jsp").forward(req, resp);
	}

	//初始化操作
	public void init() throws ServletException {
		Storedao=new StoreDaoImpl();
	}
	
}
