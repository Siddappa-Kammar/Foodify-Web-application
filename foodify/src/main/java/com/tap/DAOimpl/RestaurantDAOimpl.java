package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;
import com.tap.util.DBConnection;

public class RestaurantDAOimpl implements RestaurantDAO {

	private static final String INSERT_QUERY = "INSERT INTO restaurant(name, cuisineType, deliveryTime, address, "
											+ "adminUserId, rating, isActive, imagePath) VALUES (?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY = "SELECT * FROM restaurant WHERE restaurantId=?";
	
	private static final String UPDATE_QUERY = "UPDATE restaurant SET name = ?, cuisineType = ?, deliveryTime = ?, address = ?,"
											+ " adminUserId = ?, rating = ?, isActive = ?, imagePath=?  WHERE restaurantId=?";
	
	private static final String DELETE_QUERY = "DELETE FROM restaurant WHERE restaurantId = ?";
	
	private static final String SELECT_All_QUERY = "SELECT * FROM restaurant ";
	
	@Override
	public void addRestaurant(Restaurant rest) {
		
		Connection connection= DBConnection.getConnection();
		 try {
			PreparedStatement ptmt = connection.prepareStatement(INSERT_QUERY);
			
			ptmt.setString(1, rest.getName());
			ptmt.setString(2, rest.getCuisineType());
			ptmt.setInt(3, rest.getDeliveryTime());
			ptmt.setString(4, rest.getAddress());
			ptmt.setInt(5, rest.getAdminUserId());
			ptmt.setDouble(6, rest.getRating());
			ptmt.setInt(7, rest.getIsActive());
			ptmt.setString(8, rest.getImagePath());
			
			int i = ptmt.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}



	@Override
	public Restaurant getRestaurant(int id) {
		
		Restaurant rest = null;
		
		Connection connection= DBConnection.getConnection();
		try {
			PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY);
			
			ptmt.setInt(1, id);
			
			ResultSet result= ptmt.executeQuery();
			
			rest = getRestaurantFromResult(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rest;
	}


	@Override
	public void updateRestaurant(Restaurant rest) {
		
		Connection connection= DBConnection.getConnection();
		
		 try {
				PreparedStatement ptmt = connection.prepareStatement(UPDATE_QUERY);
				
				ptmt.setString(1, rest.getName());
				ptmt.setString(2, rest.getCuisineType());
				ptmt.setInt(3, rest.getDeliveryTime());
				ptmt.setString(4, rest.getAddress());
				ptmt.setInt(5, rest.getAdminUserId());
				ptmt.setDouble(6, rest.getRating());
				ptmt.setInt(7, rest.getIsActive());
				ptmt.setInt(8, rest.getRestId());
				ptmt.setString(9, rest.getImagePath());
				
				ptmt.executeUpdate();
//				System.out.println(i);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteRestaurant(int id) {
		
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
	public List<Restaurant> getAllRestaurant() {
		
		ArrayList<Restaurant> all = new ArrayList<Restaurant>();

		Connection connection = DBConnection.getConnection();

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery(SELECT_All_QUERY);
			
			while(res.next()) {
				
				Restaurant user = getRestaurantFromResult(res);
				all.add(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return all;
	}
	
	
	private Restaurant getRestaurantFromResult(ResultSet result) throws SQLException {
		
		Restaurant Restaurant = null;

			int restaurantId = result.getInt(1);
			String name = result.getString(2);
			String cuisineType = result.getString(3);
			int deliveryTime = result.getInt(4);
			String address = result.getString(5);
			int adminUserId = result.getInt(6);
			double rating = result.getDouble(7);
			int isActive = result.getInt(8);
			String imagePath = result.getString(9);
			
			Restaurant = new Restaurant(restaurantId, name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imagePath);
			
		return Restaurant;
	}
	
}
