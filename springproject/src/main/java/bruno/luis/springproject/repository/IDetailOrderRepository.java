package bruno.luis.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.DetailOrder;

@Repository
public interface IDetailOrderRepository extends JpaRepository<DetailOrder, Integer> {

}
