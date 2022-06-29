package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.parameter.Message;
import jp.co.aforce.various.Empty;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("/ShoppingSite/views/delete.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");

		Empty empty = new Empty();
		String m = empty.nullCheckById(id);


		try {
			if(!m.equals("")) {
				session.setAttribute("deleteMessage", m + Message.W_CCM0001);
				response.sendRedirect("/ShoppingSite/views/delete.jsp");
			} else {
				try {
					SweetDAO dao = new SweetDAO();
					dao.delete(id);
					session.setAttribute("deleteMessage", Message.I_WKK0002);
					session.removeAttribute("deleteid");
					session.removeAttribute("deleteBean");
					response.sendRedirect("/ShoppingSite/views/delete.jsp");
				} catch (Exception e) {
					session.setAttribute("deleteMessage", Message.E_WKK0004);
					response.sendRedirect("/ShoppingSite/views/delete.jsp");
				}
			}
		} catch (Exception e) {
			session.setAttribute("deleteMessage", m + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/delete.jsp");
		}



	}

}
