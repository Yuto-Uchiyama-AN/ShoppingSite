package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;
import jp.co.aforce.parameter.Message;
import jp.co.aforce.various.Empty2;
import jp.co.aforce.various.Look2;


@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductUpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("/ShoppingSite/views/proupdate.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String price=request.getParameter("price");
		String info = request.getParameter("info");
		String imgname = request.getParameter("imgname");

		Empty2 empty = new Empty2();
		String c = empty.nullCheck(id, name, price, info, imgname);
		String m =empty.nullCheckById(id);
		if(!m.equals("")) {
			session.setAttribute("updateMessage", m + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/proupdate.jsp");
		} else if(!c.equals("")) {
			session.setAttribute("updateMessage", c + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/proupdate.jsp");
		} else {
			int priceInt = Integer.parseInt(price);
			Look2 look2 = new Look2();
			try {
				SweetBean bean = look2.put(id, name, priceInt, info, imgname);
				SweetDAO dao = new SweetDAO();
				dao.update(bean);
				session.setAttribute("updateMessage", Message.I_WKK0005);
				session.removeAttribute("updateBean");
				session.removeAttribute("id");
				response.sendRedirect("/ShoppingSite/views/proupdate.jsp");

			} catch (Exception e) {
				session.setAttribute("updateMessage", Message.E_WKK0008);
				response.sendRedirect("/ShoppingSite/views/proupdate.jsp");
				e.printStackTrace();
			}
		}
	}

}
