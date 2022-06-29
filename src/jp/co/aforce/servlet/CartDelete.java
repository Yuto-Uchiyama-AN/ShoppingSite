package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.SweetBean;

@WebServlet("/jp.co.aforce.servlet/cart-delete")
public class CartDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CartDelete() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int index = Integer.parseInt(request.getParameter("itemId"));
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<SweetBean> cart = (List<SweetBean>) session.getAttribute("cart");
		cart.remove(index);
		session.setAttribute("cart", cart);
		response.sendRedirect("../views/cart.jsp");
	}

}
