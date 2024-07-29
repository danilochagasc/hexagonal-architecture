package api_ps_nexos.com.br.products_api.domain.ports;

import api_ps_nexos.com.br.products_api.domain.model.Product;

import java.util.List;

public interface ProductServicePort {

    Product findById(Long id);

    List<Product> findAll();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    String deleteProduct(Long id);
}
