package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.model.User;
import com.tap.util.DBConnection;

public class UserDAOimpl implements UserDAO {

	private static final String INSERT_QUERY = "INSERT INTO user(name, email, password, phone, address,"
											+ " role, createDate, lastLoginDate) VALUES(?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY = "SELECT * FROM user WHERE id=?";
	
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email=?";
	
	private static final String UPDATE_QUERY = "UPDATE user SET name = ?, email = ?, password = ?, phone = ?,"
											+ " address = ?, role = ?, lastLoginDate = ?  WHERE id=?";
	
	private static final String DELETE_QUERY = "DELETE FROM user WHERE id = ?";
	
	private static final String SELECT_All_QUERY = "SELECT * FROM user ";
	
	@Override
	public void addUser(User user) {
		
//		Connection connection= DBConnection.getConnection();
		 try (Connection connection= DBConnection.getConnection();
				 PreparedStatement ptmt = connection.prepareStatement(INSERT_QUERY)){
			
			
			ptmt.setString(1, user.getName());
			ptmt.setString(2, user.getEmail());
			ptmt.setString(3, user.getPassword());
			ptmt.setString(4, user.getPhone());
			ptmt.setString(5, user.getAddress());
			ptmt.setString(6, user.getRole());
			ptmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			ptmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			
			int i = ptmt.executeUpdate();
			
			if (i != 1) {
	            throw new SQLException(
	                "User registration failed. Rows inserted: " + i
	            );
	        }
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("Failed to register user.", e);
		}
		
	}
	
	@Override
	public User getUser(int id) {
	    User user = null;
	    
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY)) {
	        
	        ptmt.setInt(1, id);
	        
	        try (ResultSet result = ptmt.executeQuery()) {
	            // FIX: Added result.next() so the cursor moves to the fetched row
	            if (result.next()) {
	                user = getUserFromResult(result);
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return user;
	}

//	@Override
//	public User getUser(int id) {
//		
//		User user = null;
//		
//		Connection connection= DBConnection.getConnection();
//		try {
//			PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY);
//			
//			ptmt.setInt(1, id);
//			
//			ResultSet result= ptmt.executeQuery();
//			
//			user = getUserFromResult(result);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		return user;
//	}
	

	public User getUserByEmail(String email) {
//	    String query = "SELECT * FROM user WHERE email = ?";
	
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement ptmt = connection.prepareStatement(GET_USER_BY_EMAIL)) {
	
	        ptmt.setString(1, email);
	
	        try (ResultSet result = ptmt.executeQuery()) {
	            if (result.next()) {
	                return getUserFromResult(result);
	            }
	        }
	
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch user by email.", e);
	    }
	
	    return null;
	}



	@Override
	public void updateUser(User user) {
		
		Connection connection= DBConnection.getConnection();
		
		 try {
				PreparedStatement ptmt = connection.prepareStatement(UPDATE_QUERY);
				
				ptmt.setString(1, user.getName());
				ptmt.setString(2, user.getEmail());
				ptmt.setString(3, user.getPassword());
				ptmt.setString(4, user.getPhone());
				ptmt.setString(5, user.getAddress());
				ptmt.setString(6, user.getRole());
				ptmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				ptmt.setInt(8, user.getId());
				
				ptmt.executeUpdate();
//				System.out.println(i);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteUser(int id) {
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ptmt = connection.prepareStatement(DELETE_QUERY);
			
			ptmt.setInt(1, id);
			
			ptmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<User> getAllUser() {
		
		ArrayList<User> all = new ArrayList<User>();

		Connection connection = DBConnection.getConnection();

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery(SELECT_All_QUERY);
			
			while(res.next()) {
				
				User user = getUserFromResult(res);
				all.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return all;
	}
	
	
	private User getUserFromResult(ResultSet result) throws SQLException {
		
		User user = null;
		
		
			int id = result.getInt(1);
			String name = result.getString(2);
			String email = result.getString(3);
			String password = result.getString(4);
			String phone = result.getString(5);
			String address = result.getString(6);
			String role = result.getString(7);
			Timestamp createDate = result.getTimestamp(8);
			Timestamp lastLoginDate = result.getTimestamp(9);
			
			user = new User(id, name, email, password, phone, address, role, createDate, lastLoginDate);
			
		
			
		return user;
	}
	
}
