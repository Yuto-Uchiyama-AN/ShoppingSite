package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.MemberDAO;



@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.sendRedirect("ShoppingSite/views/login2.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String member_id = request.getParameter("id");
		String password = request.getParameter("password");
		boolean isLogin = false;
		String path = "/ShoppingSite/views/login2.jsp";
		HttpSession session = request.getSession();

		if(member_id.equals("") || password.equals("")) {
			session.setAttribute("isLogin", isLogin);
			session.setAttribute("message", "idとpassword両方入力してください");
			response.sendRedirect(path);
		} else {

		MemberDAO dao = new MemberDAO();

		try {
			String access = dao.search(member_id, password);
			if(access.equals("admin")) {
				System.out.println(access);
				request.getRequestDispatcher("/jp.co.aforce.servlet/search").include(request, response);
				response.sendRedirect("/ShoppingSite/views/insert.jsp");
			}else {
				System.out.println(access);
				response.sendRedirect("/ShoppingSite/views/product.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		}

	}

}
