package bruno.luis.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    
}
