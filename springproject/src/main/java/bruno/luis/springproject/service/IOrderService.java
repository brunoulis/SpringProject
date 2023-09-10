package bruno.luis.springproject.service;

import java.util.List;

import bruno.luis.springproject.model.Order;

public interface IOrderService {
    List<Order> findAll();

    Order save(Order order);

    String generateNumberOrder();

}
