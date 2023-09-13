package bruno.luis.springproject.service;

import java.util.List;
import java.util.Optional;

import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.model.User;

public interface IOrderService {
    List<Order> findAll();

    Order save(Order order);

    String generateNumberOrder();

    List<Order> findByUser(User user);

    Optional<Order> findById(Integer id);

}
