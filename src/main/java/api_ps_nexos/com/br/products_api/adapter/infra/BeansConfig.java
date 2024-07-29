package api_ps_nexos.com.br.products_api.adapter.infra;

import api_ps_nexos.com.br.products_api.domain.ports.ProductRepositoryPort;
import api_ps_nexos.com.br.products_api.domain.ports.ProductServicePort;
import api_ps_nexos.com.br.products_api.domain.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ProductServicePort productServicePort(ProductRepositoryPort productRepositoryPort){
        return new ProductService(productRepositoryPort);
    }
}
