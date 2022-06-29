package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.parameter.Message;
import jp.co.aforce.various.Empty;

@WebServlet("/DleteMember")
public class DleteMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DleteMember() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
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
				response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
			} else {
				try {
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					dao.delete2(id);
					session.setAttribute("deleteMessage", Message.I_WKK0003);
					session.removeAttribute("deleteid");
					session.removeAttribute("deleteBean");
					response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
				} catch (Exception e) {
					session.setAttribute("deleteMessage", Message.E_WKK0006);
					response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
				}
			}
		} catch (Exception e) {
			session.setAttribute("deleteMessage", m + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
		}



	}

}
