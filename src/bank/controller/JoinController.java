package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;
import bank.vo.Account;

public class JoinController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Account account = new Account(id, pwd);
		
		Service s = Service.getInstance();	// Service class 로 하여금 getInstance 로 해서, service 객체=s 하나를 받음.
		s.join(account); 					// service 객체에  join 메소드를 호출, 새로 생성한 account 객체를 매개변수로 받아서함.
		
		HttpUtil.forward(request, response, "/index.jsp");
		
		// DB join 은 void 이기 때문에 return 이 없음.
		// SO, HttpUtil 이용해서 저길로 가게끔....

		
	}

}
