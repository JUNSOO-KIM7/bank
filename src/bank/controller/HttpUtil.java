package bank.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	
	public static void forward(HttpServletRequest req, HttpServletResponse resp, String path)
	{
		try
		{
			RequestDispatcher rd = req.getRequestDispatcher(path);
			rd.forward(req, resp);
		}catch(Exception e)
		{
			System.out.println("HttpUtil error"+e);
		}		// throw IOException 하면, 이거 쓸때 매번 try catch 문 넣어줘야힘.
				// 보기 싫어서 여기서 그냥 넣는거임.  
	}

}
