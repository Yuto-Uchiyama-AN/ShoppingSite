package jp.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;
import jp.co.aforce.tool.Page;



@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/search" })
public class Search  extends HttpServlet {

	public void doPost(
			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

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

			for(SweetBean p : list) {
				p.getId();
				p.getName();
				p.getPrice();
				p.getInfo();
				p.getImgname();
				System.out.println(p.getId() + p.getName() + p.getPrice() + p.getInfo() + p.getImgname());
			}
		}catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}

}
