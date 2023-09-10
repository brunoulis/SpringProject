package bruno.luis.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer>{

}
