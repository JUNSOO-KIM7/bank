package bank.service;

import bank.dao.BankDao;
import bank.vo.Account;

public class Service {
	
	private static Service service = new Service(); // 여기 class 자체에서 객체 만듬.
	private Service() {} 							// 내부 생성자 = 외부에서 service 객체생성 불가.
	private BankDao dao = BankDao.getInstance(); // (joincontroller <-> service) 형태랑 동일.
	public static Service getInstance()			// 외부에서 접근하고 싶을때 class 가 갖고있는 내부 객체를 return.
	{
		return service;
	}
	public void join(Account account) {
		// TODO Auto-generated method stub
		dao.join(account);
	}
	
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.login(id,pwd);
	}
	
	public int deposit(String id, int money) {
		// TODO Auto-generated method stub
		return dao.deposit(id,money);
	}
	
	public int withdrawal(String id, int money) {
		// TODO Auto-generated method stub
		return dao.withdrawal(id,money);
	}
	public int query(String id) {
		// TODO Auto-generated method stub
		return dao.query(id);
	}
	public boolean search (String id) {
		// TODO Auto-generated method stub
		return dao.search(id);
	}
	public int transfer(String id, String rId, int money) {
		// TODO Auto-generated method stub
		return dao.transfer(id,rId,money);
	}
}
