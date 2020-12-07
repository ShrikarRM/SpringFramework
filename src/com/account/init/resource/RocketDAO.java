package com.account.init.resource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RocketDAO {

	private String url;
	private String userId;
	private String password;
	private String driverClass;
	private Connection connection;
	private PreparedStatement preparedStatement;

	public RocketDAO() {
		System.out.println(this.getClass().getSimpleName() + " created");
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void initResource() throws ClassNotFoundException, SQLException {
		System.out.println("init");
		String url = "jdbc:mysql://localhost:3306?user=root&password=root";
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(url, this.userId, this.password);
	}

	public void save(Rocket dto) throws SQLException {
		System.out.println("save");
		preparedStatement = connection.prepareStatement("insert into jdbc.rocket_table values(?,?,?)");
		preparedStatement.setString(1, dto.getCountry());
		preparedStatement.setDate(2, new Date(dto.getLaunchingDate().getTime()));
		preparedStatement.setDouble(3, dto.getCost());

		preparedStatement.execute();
	}

	public void update(Rocket dto) throws SQLException {
		System.out.println("update record");
		preparedStatement = 
		connection.prepareStatement("update jdbc.rocket_table set LaunchingDate=?,cost=? where country=?");
		preparedStatement.setDate(1, new Date(dto.getLaunchingDate().getTime()));
		preparedStatement.setDouble(2, dto.getCost());
		preparedStatement.setString(3, dto.getCountry());

		preparedStatement.execute();
	}

	public void select(Rocket dto) throws SQLException {
		System.out.println("select records");
		try (Statement statement = connection.createStatement()) {
			ResultSet set = statement.executeQuery("select * from jdbc.rocket_table");
			while (set.next()) {
				String LaunchingDate = set.getString(2);
				String country = set.getString(1);
				String cost = set.getString(3);

				System.out.println(country + " " + LaunchingDate + " " + cost);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	public void delete(Rocket dto) throws SQLException {
		System.out.println("delete record");
		preparedStatement = 
		connection.prepareStatement("delete from jdbc.rocket_table where country=?");
		preparedStatement.setString(1, dto.getCountry());
		preparedStatement.execute();
	}
	public void destroy() throws SQLException {
		connection.close();
		System.out.println("close connection");
	}
}
