package models;

import java.sql.*;


public class DBManager {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement pstatement = null;
	private ResultSet result = null;
	private boolean bestimmt = true;

	private DBManager() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");		
	}
	private static DBManager instance;
	
	public static DBManager getInstance() throws ClassNotFoundException {
		
		if(instance == null) {
				instance = new DBManager();			
			}
			System.out.println(instance);
			return instance;
		}
	
	public boolean existsAccount(Connection con,String name) throws SQLException {
		//TODO
		boolean bestimmt = true;
		statement = con.createStatement();
		result=statement.executeQuery("Select * From account;");
		
		while(result.next()) {
			if(name == result.getString("Benutzername")) {
				bestimmt = false;
			}
		}
		
		return bestimmt;
	}
	
	public boolean CreateAccount(String name, String password, String email) throws SQLException {
		connect = getConnection();
		
		if(existsAccount(connect, name)) {
			//TODO INSERT INTO TABEL#
			statement = connect.createStatement();
			String insert = "INSERT INTO `auktionshaus`.`account`("+
					"`Benutzername`," + 
					"`E-mail`," + 
					"`Passwort`)" + 
					"VALUES (?,?,?)";
			pstatement = connect.prepareStatement(insert);
			
			pstatement.setString(1, name);
			pstatement.setString(2, email);
			pstatement.setString(3, password);
			
			pstatement.executeUpdate();
			
		}else {
			bestimmt = false;
		}
		
		return bestimmt;
		
	}
	public boolean checkAccount(String name, String password) {
		return true;
	}
	public Connection getConnection() throws SQLException {
		//TODO
		String user = "root";
		String pwd = "";
		connect = DriverManager.getConnection("jdbc:mysql://localhost/Auktionshaus",user,pwd);
		return connect;
	}
	
	public void ReleaseConnection(Connection con) {
		//TODO
		try {
			if(result != null) {
				result.close();
			}
			if(con != null) {
				con.close();
			}
			if(statement != null) {
				statement.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public boolean LoginCheck(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		
		String u;
		String p;
		bestimmt=false;
		try {
			connect = this.getConnection();

			statement = connect.createStatement();
			result=statement.executeQuery("Select * From account;");
		while(result.next()) {
			u= result.getString("Benutzername");
			p = result.getString("Passwort");
			
			System.out.println("Von der Datenbank: "+u);
			System.out.println("Von der Eingabe: "+username.trim());
			if(u.equals(username)&& p.equals(password)) {
				bestimmt = true;
			}
		}
		}finally {
		ReleaseConnection(connect);
		if(result != null) {
			result.close();
		}

		if(statement != null) {
			statement.close();
		}
		}
		return bestimmt;
	}

	public boolean checkUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		String u;
		bestimmt = true;
		connect= this.getConnection();
		statement = connect.createStatement();
		result=statement.executeQuery("Select Benutzername From account;");
		
		while(result.next()) {
			u= result.getString("Benutzername");
			
			if(u == username) {
				bestimmt=false;
			}
		}
		
		
		return bestimmt;
	}
	
	
}
