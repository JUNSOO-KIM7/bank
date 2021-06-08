package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bank.vo.Account;

public class BankDao {
	private static BankDao dao = new BankDao();
	private BankDao() {}
	public static BankDao getInstance() {
		return dao;
	}
	// 여기부터 복사.
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");	// 맥북이여서 인지, 구형이라 그런건지, cj 빼야함.
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BankDB","root","22242224");
		}catch(Exception e)
		{
			System.out.println("MDAO:connect"+e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt)	// select 없는 경우엔 connect, pstmt 두개만 사용함.
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();
			}catch(Exception e) {
				System.out.print("Pstmt close error"+e);
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			}catch(Exception e)
			{
				System.out.print("Conn close error" +e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();
			}catch(Exception e)
			{
				System.out.print("rs close error" + e);
			}
		}
		close(conn,pstmt);
	}
	//여기까지 복사.
	
	public void join(Account account) {
		// TODO Auto-generated method stub
		Connection conn = null;	
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();	// 매번 DB 연결을 할때 connect 을 요청.
			pstmt = conn.prepareStatement("insert into account values(?,?,?);");
			pstmt.setString(1, account.getId());
			pstmt.setString(2, account.getPwd());
			pstmt.setString(3, account.getMoney()+"");	// getMoney가 int 로 들어가있음 // +"" 이걸로 string 변환작업.
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.println("회원가입 오류! join error! " + e);
		}
		finally
		{
			close(conn,pstmt);
		}
		
	}
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	//select 쓸때 필요.
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from account where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			else
				result = false;
		}catch(Exception e)
		{
			System.out.println("로그인 오류발생 login error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
	public int deposit(String id, int money) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int moneyDB = 0;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select money from account where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				moneyDB = rs.getInt(1);
			}
			money = moneyDB + money;
			
			pstmt = conn.prepareStatement("update account set money=? where id = ?;");
			pstmt.setString(1, money+"");	// int 타입은 money 에 아무것도 없는 문자열은 추가해서 string 타입으로 ~.
			pstmt.setString(2, id);
			pstmt.executeUpdate();			// 위에 select -> executeQuery / update -> executeUpdate
			
		}catch(Exception e)
		{
			System.out.print("입금 오류 !!! deposit error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return money;
	}
	
	public int withdrawal(String id, int money) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int moneyDB = 0;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select money from account where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
				moneyDB = rs.getInt(1);
			if(money > moneyDB)
				return -1;	//출금 못했음. 
			money = moneyDB - money;
			
			pstmt = conn.prepareStatement("update account set money=? where id = ?;");
			pstmt.setString(1, money+"");
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		}catch(Exception e)
		{
			System.out.print("출금오류!!!! withdrawal error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return money;
	}
	
	public int query(String id) {
		// TODO Auto-generated method stub
		int money = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select money from account where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				money = rs.getInt(1);
			}
			
		}catch(Exception e)
		{
			System.out.print("조회 오류 !!!! qurey error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return money;
	}
	
	public boolean search(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id from account where id = ? ;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result = true;
			}
			
		}catch(Exception e)
		{
			System.out.print("아이디 조회 오류 search error" + e);
		}
		finally
		{
			close(conn,pstmt,rs);
		}
		return result;
	}
	
	public int transfer(String id, String rId, int money) {
		// TODO Auto-generated method stub
		int tMoney = this.withdrawal(id, money);	// id 에서 money 만큼 출금작업 먼저....
		if(tMoney < 0)
			return tMoney;
		this.deposit(rId,  money);
		return tMoney;
	}
}
