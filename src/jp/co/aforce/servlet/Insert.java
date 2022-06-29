package jp.co.aforce.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import jp.co.aforce.DAO.SweetDAO;
import jp.co.aforce.bean.SweetBean;
import jp.co.aforce.tool.Page;



@WebServlet(urlPatterns = { "/jp.co.aforce.servlet/insert" })
@MultipartConfig
public class Insert extends HttpServlet {

	public void doPost(

			HttpServletRequest request, HttpServletResponse response
			) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);

		try {
			String name = request.getParameter("name");
			System.out.println(request.getParameter("price"));
			int price = Integer.parseInt(request.getParameter("price"));
			String info = request.getParameter("info");

			Part part=request.getPart("imgname");
			String imgname=part.getSubmittedFileName();
			System.out.println(imgname);
			String path=getServletContext().getRealPath("/img");
			System.out.println(path+File.separator+imgname);
			part.write(path+File.separator+imgname);

			SweetBean p = new SweetBean();
			p.setName(name);
			p.setPrice(price);
			p.setInfo(info);
			p.setImgname(imgname);

			SweetDAO dao = new SweetDAO();
			int line = dao.insert(p);

			if(line>0) {
				out.println("追加に成功しました。");
			}

		}catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);

	}

}
