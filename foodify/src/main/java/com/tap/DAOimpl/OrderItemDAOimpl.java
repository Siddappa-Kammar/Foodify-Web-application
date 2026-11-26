package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;
import com.tap.util.DBConnection;

public class OrderItemDAOimpl implements OrderItemDAO{
	
	private static final String INSERT_QUERY = "INSERT INTO orderitem(orderId, menuId, quantity, itemTotal) "
											+ "VALUES(?,?,?,?)";
	
	private static final String SELECT_QUERY = "SELECT * FROM orderitem  WHERE orderItemId = ?";
	
	private static final String UPDATE_QUERY = "UPDATE orderitem SET ";
	
	private static final String DELETE_QUERY = "DELETE orderitem WHERE orderItemId=? ";
	
	private static final String SELECT_ALL_QUERY = "SELECT * FROM orderitem";
	
	private static final String SELECT_ORDERITEM_BY_ODERID =  "SELECT oi.orderItemId AS OIid, oi.orderId, oi.menuId, " +
		    "oi.quantity, oi.itemTotal, m.itemName, m.price, m.imagePath " +
		    "FROM orderitem oi JOIN menu m ON oi.menuId = m.menuId " +
		    "WHERE oi.orderId = ?";

	@Override
	public void addOrderItem(OrderItem item, Connection connection)
	        throws SQLException {

	    try (PreparedStatement ps =
	            connection.prepareStatement(INSERT_QUERY)) {

	        ps.setInt(1, item.getOrderId());
	        ps.setInt(2, item.getMenuId());
	        ps.setInt(3, item.getQuantity());
	        ps.setDouble(4, item.getItemTotal());

	        int rows = ps.executeUpdate();

	        if (rows != 1) {
	            throw new SQLException("Order item was not inserted.");
	        }
	    }
	}

	
//	public OrderItem getOrderItem(int id) {
//		
//		OrderItem orderItem = null;
//		
//		Connection connection = DBConnection.getConnection();
//		
//		try {
//			PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY);
//			
//			ptmt.setInt(1, id);
//			
//			ResultSet result = ptmt.executeQuery();
//			
//			orderItem = getOrderItemResult(result);
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return orderItem;
//	}
	
	@Override
	public OrderItem getOrderItem(int id) {
	    try (Connection connection = DBConnection.getConnection();
	         PreparedStatement ps = connection.prepareStatement(SELECT_QUERY)) {

	        ps.setInt(1, id);

	        try (ResultSet result = ps.executeQuery()) {
	            if (result.next()) {
	                return getOrderItemResult(result);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return null;
	}
	
	public void updateOrderItem(OrderItem oi) {
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ptmt = connection.prepareStatement(UPDATE_QUERY);
			
			int i = ptmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteOrderItem(int id) {
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement ptmt= connection.prepareStatement(DELETE_QUERY);
			
//			ps.setInt(1, id);
			int i = ptmt.executeUpdate();
			System.out.println(i);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<OrderItem> getAllOrderItem() {
		
		Connection connection = DBConnection.getConnection();
		
		ArrayList<OrderItem> all = new ArrayList<OrderItem>();
		
		try {
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery(SELECT_ALL_QUERY);
			
			while(res.next()) {
				
				OrderItem oi = getOrderItemResult(res);
				all.add(oi);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return all;
	}
	

	public List<OrderItem> getOrderItemsByOrderId(int orderId) {

	    List<OrderItem> items = new ArrayList<>();

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps =
	             con.prepareStatement(SELECT_ORDERITEM_BY_ODERID)) {

	        ps.setInt(1, orderId);

	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {

	                OrderItem item = new OrderItem(
	                    rs.getInt("OIid"),
	                    rs.getInt("orderId"),
	                    rs.getInt("menuId"),
	                    rs.getInt("quantity"),
	                    rs.getDouble("itemTotal")
	                );

	                item.setItemName(rs.getString("itemName"));
	                item.setUnitPrice(rs.getDouble("price"));
	                item.setImagePath(rs.getString("imagePath"));

	                items.add(item);
	            }
	        }

	    } catch (SQLException e) {
	        throw new RuntimeException(
	            "Failed to retrieve items for order " + orderId, e);
	    }

	    return items;
	}
	
	public OrderItem getOrderItemResult(ResultSet res) throws SQLException {
		
		OrderItem orderItem = null;
		
		int OIid = res.getInt(1);
		int orderId = res.getInt(2);
		int menuId = res.getInt(3);
		int quantity = res.getInt(4);
		double itemTotal = res.getDouble(5);
		
		orderItem = new OrderItem(OIid, orderId, menuId, quantity, itemTotal);
		
		return orderItem;
		
	}
	

}
