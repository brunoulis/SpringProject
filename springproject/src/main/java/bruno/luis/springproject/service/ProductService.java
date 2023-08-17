package bruno.luis.springproject.service;

import java.util.Optional;

import bruno.luis.springproject.model.Product;

public interface ProductService {
	public Product save(Product product);

	public Optional<Product> get(Integer id);

	public void update(Product product);

	public void delete(Integer id);

}