package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;

@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/cart-plus" })
public class CartPlus extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doPost(

			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		jp.co.aforce.tool.Page.header(out);

		String id = request.getParameter("itemId");
		SweetDAO sweetdao = new SweetDAO();
		HttpSession session = request.getSession();

		List<SweetBean> cart = (List<SweetBean>)session.getAttribute("cart");
		if(cart==null) {
			cart=new ArrayList<SweetBean>();

		}

		SweetBean p = null;
		try {
			p = sweetdao.findById(id);
		} catch (Exception e) {

			e.printStackTrace();
		}
		cart.add(p);

		session.setAttribute("cart", cart);

		session.setAttribute("message", "カートに商品を追加しました。");
		response.sendRedirect("../views/cart.jsp");
		jp.co.aforce.tool.Page.footer(out);
	}



}
