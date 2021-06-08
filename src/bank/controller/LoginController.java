package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class LoginController implements Controller {
	
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Service s = Service.getInstance();
		boolean result = s.login(id, pwd);
		String path = null;
		
		if(result)
		{
			HttpSession session = request.getSession();	// 세션 생성 및 얻기.
			session.setAttribute("id", id);				// ("name", value) // 세션에 값 저장. // 객체 object 저장.
			path = "/menu.jsp";
		}
		else
		{
			path = "/index.jsp";
		}
		HttpUtil.forward(request, response, path);

	}
}
