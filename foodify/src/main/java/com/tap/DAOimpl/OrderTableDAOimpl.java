package com.tap.DAOimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.OrderTableDAO;
import com.tap.model.OrderTable;
import com.tap.util.DBConnection;

public class OrderTableDAOimpl implements OrderTableDAO {

    private static final String INSERT_QUERY = "INSERT INTO ordertable(userId, restId, orderDate, totalAmount, status, paymentMethod) VALUES(?,?,?,?,?,?)";
    private static final String SELECT_QUERY = "SELECT * FROM ordertable WHERE id=?";
    private static final String UPDATE_QUERY = "UPDATE ordertable SET userId = ?, restId = ?, orderDate = ?, totalAmount = ?, status = ?, paymentMethod = ? WHERE id=?";
    private static final String DELETE_QUERY = "DELETE FROM ordertable WHERE id = ?";
    private static final String SELECT_All_QUERY = "SELECT * FROM ordertable";
    private static final String GET_ORDER_BY_USERID = "SELECT orderId, userId, restId, orderDate, totalAmount, status, paymentMethod " +
            "FROM ordertable WHERE userId = ? ORDER BY orderDate DESC";
    
    // Updated to accept the transactional Connection
    public int addOrderTable(OrderTable order, Connection connection) throws SQLException {
        int generatedOrderId = -1;
        
        try (PreparedStatement ps = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestId());
            ps.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getStatus());
            ps.setString(6, order.getPaymentMethod());
    
            int rows = ps.executeUpdate();
            if (rows != 1) {
                throw new SQLException("Order table insertion failed. Rows affected: " + rows);
            }
    
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    generatedOrderId = keys.getInt(1);
                    order.setOrderId(generatedOrderId);
                }
            }
        }
        return generatedOrderId;
    }

    // Non-transactional fallback
    public int addOrderTable(OrderTable order) {
        try (Connection connection = DBConnection.getConnection()) {
            return addOrderTable(order, connection);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to add order table", e);
        }
    }

    @Override
    public OrderTable getOrderTable(int id) {
        OrderTable orderTable = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(SELECT_QUERY)) {
            ptmt.setInt(1, id);
            try (ResultSet result = ptmt.executeQuery()) {
                if (result.next()) {
                    orderTable = getOrderTableFromResult(result);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderTable;
    }

    @Override
    public void updateOrderTable(OrderTable ot) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(UPDATE_QUERY)) {
            ptmt.setInt(1, ot.getUserId());
            ptmt.setInt(2, ot.getRestId());
            ptmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            ptmt.setDouble(4, ot.getTotalAmount());
            ptmt.setString(5, ot.getStatus());
            ptmt.setString(6, ot.getPaymentMethod());
            ptmt.setInt(7, ot.getOrderId());
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrderTable(int id) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ptmt = connection.prepareStatement(DELETE_QUERY)) {
            ptmt.setInt(1, id);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderTable> getAllOrderTable() {
        ArrayList<OrderTable> all = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet res = stmt.executeQuery(SELECT_All_QUERY)) {
            while (res.next()) {
                OrderTable orderTable = getOrderTableFromResult(res);
                all.add(orderTable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
    

	public List<OrderTable> getOrdersByUserId(int userId) {
	
	    List<OrderTable> orders = new java.util.ArrayList<>();
	
	//    String sql =
	//        "SELECT orderId, userId, restId, orderDate, " +
	//        "totalAmount, status, paymentMethod " +
	//        "FROM ordertable WHERE userId = ? " +
	//        "ORDER BY orderDate DESC";
	
	    try (java.sql.Connection con =
	             com.tap.util.DBConnection.getConnection();
	         java.sql.PreparedStatement ps = con.prepareStatement(GET_ORDER_BY_USERID)) {
	
	        ps.setInt(1, userId);
	
	        try (java.sql.ResultSet rs = ps.executeQuery()) {
	
	            while (rs.next()) {
	                OrderTable order = new OrderTable(
	                    rs.getInt("orderId"),
	                    rs.getInt("userId"),
	                    rs.getInt("restId"),
	                    rs.getTimestamp("orderDate"),
	                    rs.getDouble("totalAmount"),
	                    rs.getString("status"),
	                    rs.getString("paymentMethod")
	                );
	
	                orders.add(order);
	            }
	        }
	
	    } catch (java.sql.SQLException e) {
	        throw new RuntimeException("Failed to retrieve user orders.", e);
	    }
	
	    return orders;
	}

    
    private OrderTable getOrderTableFromResult(ResultSet result) throws SQLException {
        int orderId = result.getInt(1);
        int userId = result.getInt(2);
        int restId = result.getInt(3);
        Timestamp orderdate = result.getTimestamp(4);
        double totalAmount = result.getDouble(5);
        String status = result.getString(6);
        String paymentMethod = result.getString(7);
        
        return new OrderTable(orderId, userId, restId, orderdate, totalAmount, status, paymentMethod);
    }
}