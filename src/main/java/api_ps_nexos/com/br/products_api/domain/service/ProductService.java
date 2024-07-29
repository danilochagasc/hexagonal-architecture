package api_ps_nexos.com.br.products_api.domain.service;

import api_ps_nexos.com.br.products_api.domain.model.Product;
import api_ps_nexos.com.br.products_api.domain.ports.ProductRepositoryPort;
import api_ps_nexos.com.br.products_api.domain.ports.ProductServicePort;

import java.util.List;

public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductService(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Product findById(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepositoryPort.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepositoryPort.save(product);
    }

    @Override
    public Product updateProduct( Long id, Product product) {

        Product newProduct = productRepositoryPort.findById(id);

        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());
        newProduct.setQuantity(product.getQuantity());

        return productRepositoryPort.save(newProduct);

    }

    @Override
    public String deleteProduct(Long id) {
        try {
            productRepositoryPort.deleteById(id);
            return "Product deleted successfully!";
        }catch (Exception e){
            return "Error deleting product";
        }

    }
}
