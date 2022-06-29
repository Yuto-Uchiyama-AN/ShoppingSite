package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.bean.SweetBean;
import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/cart-info" })
public class CartInfo extends HttpServlet {

	@SuppressWarnings("unchecked")
	public void doGet(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

		HttpSession session = request.getSession();

		List<SweetBean> cart = (List<SweetBean>)session.getAttribute("cart");
		if(cart!=null) {
			for(SweetBean p : cart) {
				out.println("<p>");
				out.println(p.getName());
				out.println(":");
				out.println(p.getPrice());
				out.println(":");
				out.println(p.getInfo());
				out.println(":");
				out.println(p.getImgname());
				out.println("</p>");
			}
		}else {
			out.println("カートの中身は空です。");
		}
		Page.footer(out);
	}

}
