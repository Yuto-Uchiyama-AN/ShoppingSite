package jp.co.aforce.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.aforce.tool.Action;

public  class LogoutAction extends Action {
	public String execute(
			HttpServletRequest request, HttpServletResponse response
			)throws Exception{
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session=request.getSession();
		if(session.getAttribute("memberbean") != null) {
			session.removeAttribute("memberbean");
			return "logout.jsp";
		}
		return "logout-er.jsp";
	}

}
