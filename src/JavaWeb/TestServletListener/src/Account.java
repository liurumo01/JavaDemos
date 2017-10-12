public class Account {
	public static Account account = null;
	
	private int id; //ÕË»§±àºÅ
	private String name; //µÇÂ¼Ãû
	private String key; //µÇÂ½ÃÜÂë
	
	public Account() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Account getAccount() {
		return account;
	}

	public static void setAccount(Account account) {
		Account.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
