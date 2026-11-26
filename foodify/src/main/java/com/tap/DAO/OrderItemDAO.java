
package com.tap.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.tap.model.OrderItem;

public interface OrderItemDAO {

    void addOrderItem(OrderItem item, Connection connection)
            throws SQLException;

    OrderItem getOrderItem(int id);

    void updateOrderItem(OrderItem item);

    void deleteOrderItem(int id);

    List<OrderItem> getAllOrderItem();
    
    List<OrderItem> getOrderItemsByOrderId(int orderId);
}
