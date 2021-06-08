package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.service.Service;

public class DepositController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int money = Integer.parseInt(request.getParameter("money")); // string -> 정수 변환.
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");		// logincontroller 에서 만든거 가져옴. ()안에 타입으로 캐스팅. // 왼항으로 받아옴.
		
		Service s = Service.getInstance();
		int totalMoney = s.deposit(id,money);
		
		request.setAttribute("money", money);
		request.setAttribute("tMoney", totalMoney);
		
		HttpUtil.forward(request, response, "/result/depositResult.jsp");
	}

}
