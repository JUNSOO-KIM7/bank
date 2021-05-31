package bank.service;

import bank.dao.BankDao;
import bank.vo.Account;

public class Service {
	
	private static Service service = new Service(); // 여기 안에서.. 객체 만듬.
	private Service() {} // 외부에서 service 객체생성 불가.
	private BankDao dao = BankDao.getInstance(); // 여기서 dao 계속 쓸거기 떄문,
	public static Service getInstance()	// <- 한번만 생성된 객체를 가져옴.
	{
		return service;
	}
	public void join(Account account) {
		// TODO Auto-generated method stub
		dao.join(account);
	}
	public Boolean login(String id, String pwd) {
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
