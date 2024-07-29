package api_ps_nexos.com.br.products_api.domain.ports;

import api_ps_nexos.com.br.products_api.domain.model.Product;

import java.util.List;

public interface ProductRepositoryPort {

    Product findById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);
}
