package bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.service.Service;

public class WithdrawalController implements Controller {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int money = Integer.parseInt(request.getParameter("money"));
		
		String id = (String)(request.getSession().getAttribute("id"));	// 한번에 처리
		
		int tMoney = Service.getInstance().withdrawal(id, money);		// 한번에 처리
		if(tMoney < 0)
		{
			request.setAttribute("result", "Money is not enough");
		}
		
		request.setAttribute("money", money);
		request.setAttribute("tMoney", tMoney);
		
		HttpUtil.forward(request, response, "/result/withdrawalResult.jsp");
	}

}
