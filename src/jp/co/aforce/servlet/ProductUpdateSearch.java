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

@WebServlet("/ProductUpdateSearch")
public class ProductUpdateSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductUpdateSearch() {
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

		SweetDAO sweetDAO = new SweetDAO();

		try {
			SweetBean sweetBean = sweetDAO.findById(id);
			session.setAttribute("proupdateBean", sweetBean);
			response.sendRedirect("/ShoppingSite/views/proupdate.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
