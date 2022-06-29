package jp.co.aforce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.aforce.DAO.MemberDAO;
import jp.co.aforce.bean.MemberBean;
import jp.co.aforce.bean.RoleBean;

@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/Servret" })
public class Servret extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response
			)throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String role = request.getParameter("A");


		MemberBean i = new MemberBean(id, name,password);

		RoleBean roleBean = new RoleBean(id, role, password);


		MemberDAO dao = new MemberDAO();
		try {

			int info = dao.search(id, name, password);
			if(info >= 1) {
				request.setAttribute("message", "すでに登録されています。");
				request.getRequestDispatcher("../views/newlogin.jsp").forward(request, response);

		} else {
			try {
				dao.insert(i);
				dao.insertRole(roleBean);
				request.setAttribute("message", "登録に成功しました。");
				request.getRequestDispatcher("../views/newlogin.jsp").forward(request, response);
			}catch(Exception e) {
				request.setAttribute("message", "登録に失敗しました。");
				request.getRequestDispatcher("../views/newlogin.jsp").forward(request, response);
				e.printStackTrace();
			}

		}

		} catch (Exception e) {

			e.printStackTrace();
		}


	}


}
