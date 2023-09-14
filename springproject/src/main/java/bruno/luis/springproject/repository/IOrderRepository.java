package bruno.luis.springproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.Order;
import bruno.luis.springproject.model.UserModel;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(UserModel user);
}
