
package com.tap.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tap.model.OrderTable;

public interface OrderTableDAO {

    int addOrderTable(OrderTable order, Connection connection)
            throws SQLException;

    OrderTable getOrderTable(int id);

    void updateOrderTable(OrderTable order);

    void deleteOrderTable(int id);

    List<OrderTable> getAllOrderTable();
    
    List<OrderTable> getOrdersByUserId(int userId);
}
