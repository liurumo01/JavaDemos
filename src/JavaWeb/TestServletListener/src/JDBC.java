import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC {
	private static Connection getConnection() throws SQLException //获取数据库连接
	{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/account","snowwolf","snowwolf");
		return conn;
	}
	
	public static int addPage(Page p) { //插入新纪录
		int result = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement stmt=conn.prepareStatement("insert into page (id,time,item,amount,type,info) values (?,?,?,?,?,?)");
			stmt.setInt(1, getNextPageId());
			stmt.setTimestamp(2, p.getTime());
			stmt.setString(3, p.getItem());
			stmt.setInt(4, p.getAmount());
			stmt.setString(5, p.getType());
			stmt.setString(6, p.getInfo());
			System.out.println(stmt);
			result = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int deletePage(int id){ //删除编号为id的记录并将其后记录前移，使序号连续
		Connection conn;
		int result = 0;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			PreparedStatement stmt=conn.prepareStatement("delete from page where id = ?");
			stmt.setInt(1, (id + 1));
			System.out.println(stmt);
			result = stmt.executeUpdate();
			for(int i=(id+1);i<JDBC.getSize()+1;i++) {
				PreparedStatement stmt1 = conn.prepareStatement("update page set id = ? where id = ?");
				stmt1.setInt(1, i);
				stmt1.setInt(2, (i+1));
				System.out.println(stmt);
				stmt1.executeUpdate();
			}
			conn.commit();
			conn.setAutoCommit(true);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static int updatePage(Page page) { //修改记录信息
		Connection conn;
		int result = 0;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("update page set time = ?,item = ?,amount = ?,type = ?,info = ? where id = ?");
			stmt.setTimestamp(1, page.getTime());
			stmt.setString(2, page.getItem());
			stmt.setInt(3, page.getAmount());
			stmt.setString(4, page.getType());
			stmt.setString(5, page.getInfo());
			stmt.setInt(6, page.getId());
			System.out.println(stmt);
			result = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static int getSize(){
		Connection conn;
		int n = 0;
		try {
			conn = getConnection();
			PreparedStatement stmt=conn.prepareStatement("select count(*) from page");
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			n = rs.getInt(1);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	public static Page getPage(int id) {
		Connection conn;
		Page page = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from page where id = ?");
			stmt.setInt(1,id);
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			rs.next();
			page = new Page();
			page.setId(rs.getInt("id"));
			page.setTime(rs.getTimestamp("time"));
			page.setItem(rs.getString("item"));
			page.setAmount(rs.getInt("amount"));
			page.setType(rs.getString("type"));
			page.setInfo(rs.getString("info"));
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return page;
	}
	
	public static Object[][] getPages() { //以Object数组形式返回所有记录
		Connection conn;
		int n = 0;
		Object[][] get = new Object[JDBC.getSize()][4];
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from page");
			System.out.println(stmt);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()){
				get[n][0]=rs.getString(2);
				get[n][1]=rs.getString(3);
				get[n][2]=rs.getInt(4);
				get[n][3]=rs.getString(5);
				n++;
			}			
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();}
		return get;
	}
	
	private static int getNextPageId() { //查询下一条待插入记录的id
		Connection conn;
		int id = 0;
		try {
			conn = getConnection();
			PreparedStatement stmt=conn.prepareStatement("select count(id)+1 from page");
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			id = rs.getInt(1);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public static int addAccount(Account account) { //增加用户
		int result = 0;
		try {
			Connection conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("insert into account (id,name,`key`) values (?,?,?)");
			stmt.setInt(1, getNextAccountId());
			stmt.setString(2, account.getName());
			stmt.setString(3, account.getKey());
			System.out.println(stmt);
			result = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static Account getAccount(String name) { //根据用户名查找用户信息
		Connection conn;
		Account account = null;
		try {
			conn = getConnection();
			PreparedStatement stmt = conn.prepareStatement("select * from account where name = ?");
			stmt.setString(1,name);
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				account = new Account();
				account.setId(rs.getInt("id"));
				account.setName(rs.getString("name"));
				account.setKey(rs.getString("key"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	public static int updateAccount(Account account) { //修改用户信息
		Connection conn;
		int result = 0;
		try {
			conn = getConnection();
			PreparedStatement stmt=conn.prepareStatement("update account set `key` = ? where id = ?");
			stmt.setString(1, account.getKey());
			stmt.setInt(2, account.getId());
			System.out.println(stmt);
			result = stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static int getNextAccountId() { //获取下一名用户的id
		Connection conn;
		int id = 0;
		try {
			conn = getConnection();
			PreparedStatement stmt=conn.prepareStatement("select count(id)+1 from account");
			System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			id = rs.getInt(1);
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
