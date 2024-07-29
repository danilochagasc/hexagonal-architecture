package api_ps_nexos.com.br.products_api.adapter.repository;

import api_ps_nexos.com.br.products_api.adapter.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
