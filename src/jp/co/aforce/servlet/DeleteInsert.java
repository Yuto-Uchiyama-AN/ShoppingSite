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

@WebServlet("/DeleteSearchServlet")
public class DeleteInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteInsert() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("/ShoppingSite/views/delete.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		try {
			String id = request.getParameter("id");
			if(id.equals("") || id.equals(null)) {
				session.setAttribute("deleteMessage", "会員番号" + Message.W_CCM0001);
				response.sendRedirect("/ShoppingSite/views/delete.jsp");
			} else {
				MemberBean bean = new MemberBean();
				MemberDAO dao = new MemberDAO();

				try {
					bean = dao.findById(id);
					if(bean == null) {
						throw new Exception();
					}
					session.setAttribute("deleteid", id);
					session.setAttribute("deleteBean", bean);
					response.sendRedirect("/ShoppingSite/views/delete.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					session.setAttribute("deleteMessage", Message.E_WKK0003);
					response.sendRedirect("/ShoppingSite/views/delete.jsp");
				}
			}
		} catch (Exception e) {
			session.setAttribute("deleteMessage", "会員番号" + Message.W_CCM0001);
			response.sendRedirect("/ShoppingSite/views/delete.jsp");
		}
	}

}
