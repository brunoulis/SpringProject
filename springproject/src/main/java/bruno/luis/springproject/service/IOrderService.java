package bruno.luis.springproject.service;

import java.util.List;
import java.util.Optional;

import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.model.UserModel;

public interface IOrderService {
    List<Order> findAll();

    Order save(Order order);

    String generateNumberOrder();

    List<Order> findByUser(UserModel user);

    Optional<Order> findById(Integer id);

}
