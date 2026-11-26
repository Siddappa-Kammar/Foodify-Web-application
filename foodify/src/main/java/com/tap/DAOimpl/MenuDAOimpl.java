package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;
import com.tap.util.DBConnection;

public class MenuDAOimpl implements MenuDAO {

	private static final String INSERT_QUERY = "INSERT INTO menu(restId, itemName, description, price, isAvailable,"
											+ " category, createdAt, updatedAt, deletedAt, imagePath) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	private static final String SELECT_QUERY = "SELECT * FROM menu WHERE menuId=?";
	
	private static final String UPDATE_QUERY = "UPDATE menu SET restId = ?, itemName = ?, description = ?, price = ?,"
											+ " isAvailable = ?, category = ?, createdAt = ?, updatedAt =?, "
											+ "deletedAt = ?, imagePath=? WHERE menuId=?";
	
	private static final String DELETE_QUERY = "DELETE FROM menu WHERE menuId = ?";
	
	private static final String SELECT_All_QUERY = "SELECT * FROM menu ";
	
	private static final String GET_MENU_BY_RESTID = "SELECT * FROM menu WHERE restId=? ";
	
	@Override
	public void addMenu(Menu menu) {
		
		Connection connection= DBConnection.getConnection();
		 try {
			PreparedStatement ptmt = connection.prepareStatement(INSERT_QUERY);
			
			ptmt.setInt(1, menu.getRestId());
			ptmt.setString(2, menu.getItemName());
			ptmt.setString(3, menu.getDescription());
			ptmt.setDouble(4, menu.getPrice());
			ptmt.setBoolean(5, menu.getIsAvailable());
			ptmt.setString(6, menu.getCategory());
			ptmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
			ptmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			ptmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			ptmt.setString(10, menu.getImagePath());

			
			int i = ptmt.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

	@Override
	public Menu getMenu(int id) {
		
		Menu menu = null;
		
		Connection connection= DBConnection.getConnection();
		try {
			PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY);
			
			ptmt.setInt(1, id);
			
			ResultSet result= ptmt.executeQuery();
			
			if (result.next()) {
				menu = getMenuFromResult(result);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return menu;
	}


	@Override
	public void updateMenu(Menu menu) {
		
		Connection connection= DBConnection.getConnection();
		
		 try {
				PreparedStatement ptmt = connection.prepareStatement(UPDATE_QUERY);
				

				ptmt.setInt(1, menu.getRestId());
				ptmt.setString(2, menu.getItemName());
				ptmt.setString(3, menu.getDescription());
				ptmt.setDouble(4, menu.getPrice());
				ptmt.setBoolean(5, menu.getIsAvailable());
				ptmt.setString(6, menu.getCategory());
				ptmt.setTimestamp(7, new Timestamp(System.currentTimeMillis()));
				ptmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
				ptmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
				ptmt.setString(10, menu.getImagePath());
				ptmt.setInt(11, menu.getMenuId());
				
				ptmt.executeUpdate();
//				System.out.println(i);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void deleteMenu(int id) {
		
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
	public List<Menu> getAllMenu() {
		
		ArrayList<Menu> all = new ArrayList<Menu>();

		Connection connection = DBConnection.getConnection();

		try {
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery(SELECT_All_QUERY);
			
			while(res.next()) {
				
				Menu menu = getMenuFromResult(res);
				all.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return all;
	}
	
public List<Menu> getMenuByRestaurantId(int restaurantId) {
		
		ArrayList<Menu> all = new ArrayList<Menu>();

		Connection connection = DBConnection.getConnection();

		try {
			PreparedStatement ptmt = connection.prepareStatement(GET_MENU_BY_RESTID);
			
			ptmt.setInt(1, restaurantId);
			
			ResultSet res= ptmt.executeQuery();
			
			while(res.next()) {
				
				Menu menu = getMenuFromResult(res);
				all.add(menu);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return all;
	}
	
	
	private Menu getMenuFromResult(ResultSet result) throws SQLException {
		
		Menu menu = null;
		
		
			int menuId = result.getInt(1);
			int restId = result.getInt(2);
			String itemName = result.getString(3);
			String description = result.getString(4);
			double price = result.getDouble(5);
			boolean isAvailable = result.getBoolean(6);
			String category = result.getString(7);
			Timestamp createAt = result.getTimestamp(8);
			Timestamp updatedAt = result.getTimestamp(9);
			Timestamp deletedAt = result.getTimestamp(10);
			String imagePath = result.getString(11);
			
			menu = new Menu(menuId, restId, itemName, description, price, isAvailable,
							category, createAt, updatedAt, deletedAt, imagePath);
			
		return menu;
	}
	
}
