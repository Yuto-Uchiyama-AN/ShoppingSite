package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.parameter.Message;
import jp.co.aforce.various.Empty;
import jp.co.aforce.various.Look;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("/ShoppingSite/views/update.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		Empty empty = new Empty();
		String c = empty.nullCheck(id, name, password);
		String m =empty.nullCheckById(id);
		if(!m.equals("")) {
			session.setAttribute("updateMessage", m + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/update.jsp");
		} else if(!c.equals("")) {
			session.setAttribute("updateMessage", c + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/update.jsp");
		} else {
			Look look = new Look();
			try {
				MemberBean bean = look.put(id, name, password);
				MemberDAO dao = new MemberDAO();
				dao.update(bean);
				session.setAttribute("updateMessage", Message.I_WKK0004);
				session.removeAttribute("updateBean");
				session.removeAttribute("id");
				response.sendRedirect("/ShoppingSite/views/update.jsp");

			} catch (Exception e) {
				session.setAttribute("updateMessage", Message.E_WKK0007);
				response.sendRedirect("/ShoppingSite/views/update.jsp");
				e.printStackTrace();
			}
		}
	}

}