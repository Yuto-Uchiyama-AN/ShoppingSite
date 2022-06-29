package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;

/**
 * Servlet implementation class ProductSearch
 */
@WebServlet("/ProductSearch")
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		try {
			String keyword = request.getParameter("keyword");
			System.out.println(keyword);
			try {
				if(keyword == null) {
					keyword = "";
				}
			} catch (Exception e) {
				keyword = "";
			}

			SweetDAO dao = new SweetDAO();
			List<SweetBean> list =  dao.search(keyword);

			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			response.sendRedirect("/ShoppingSite/views/product.jsp");
		}catch (Exception e) {
		}
	}

}
