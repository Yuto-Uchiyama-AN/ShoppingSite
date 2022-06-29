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


@WebServlet("/MemberSearch")
public class MemberSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String id = request.getParameter("id");

		MemberDAO memberDAO = new MemberDAO();

		try {
			MemberBean memberBean = memberDAO.findById(id);
			session.setAttribute("deleteBean", memberBean);
			response.sendRedirect("/ShoppingSite/views/memdelete.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
