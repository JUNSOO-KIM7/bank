package bank.vo;

public class Account {
	private String id;
	private String pwd;
	private int money;
	
	//생성자를 하나 만듬 ! // setter 안쓰고 바로 매개변수로 처리하게끔.
	public Account() {}	// 디폴트 생성자 하나 넣는것이 좋음. // 오버로딩을 하기떄문.
	public Account(String tId, String tPwd)
	{
		this.id=tId;
		this.pwd=tPwd; 
		this.money=0;	// money는 0으로 초기화 
	}
	
	public String getId()
	{
		return id;
	}
	public void setId(String tId)
	{
		this.id=tId;
	}
	
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String tPwd)
	{
		this.pwd=tPwd;
	}
	
	public int getMoney()
	{
		return money;
	}
	public void setMoney(int tMoney)
	{
		this.money=tMoney;
	}

}
