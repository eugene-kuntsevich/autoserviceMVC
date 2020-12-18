package org.autoservice.dao.api;

import org.autoservice.model.Order;

import java.util.List;

public interface OrderDao extends GenericDao<Order>{
    List<Order> getOrdersByCarId(long id);
    List<Order> getOrdersByStatusId(long id);
}
