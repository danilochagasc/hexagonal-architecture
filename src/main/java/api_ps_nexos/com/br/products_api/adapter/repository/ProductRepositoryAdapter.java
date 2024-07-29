package api_ps_nexos.com.br.products_api.adapter.repository;

import api_ps_nexos.com.br.products_api.adapter.entity.ProductEntity;
import api_ps_nexos.com.br.products_api.domain.model.Product;
import api_ps_nexos.com.br.products_api.domain.ports.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Product findById(Long id) {
        return modelMapper.map(productRepository.findById(id), Product.class);
    }

    @Override
    public List<Product> findAll() {
        List<ProductEntity> products = productRepository.findAll();

        return products.stream()
                .map(productEntity -> modelMapper.map(productEntity, Product.class))
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {

        ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);

        //retornando o produto salvo
        return modelMapper.map(productRepository.save(productEntity), Product.class);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
