package jp.co.aforce.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;

@WebServlet("/Admin")
@MultipartConfig
public class Admin extends HttpServlet {
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		SweetDAO dao=new SweetDAO();
//		List<SweetBean> list=dao.findAll();
//		session.setAttribute("list", list);
////		RequestDispatcher rd=request.getRequestDispatcher
//		response.sendRedirect("/ShoppingSite/views/menu.jsp");
////		rd.forward(request, response);
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		int price=Integer.parseInt(request.getParameter("price"));
		String info=request.getParameter("info");
		Part part=request.getPart("imgname");
		String imgname=part.getSubmittedFileName();
		System.out.println(imgname);
		String path=getServletContext().getRealPath("/img");
		part.write(path+File.separator+imgname);
		SweetDAO dao=new SweetDAO();
		try {
			dao.insert(new SweetBean(name,price,info,imgname));
			response.sendRedirect("/ShoppingSite/views/insert.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
//		doGet(request,response);
	}

}
