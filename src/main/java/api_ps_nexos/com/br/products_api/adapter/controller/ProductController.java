package api_ps_nexos.com.br.products_api.adapter.controller;

import api_ps_nexos.com.br.products_api.domain.model.Product;
import api_ps_nexos.com.br.products_api.domain.ports.ProductServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServicePort productServicePort;

    @GetMapping()
    public List<Product> findAll() {
        return productServicePort.findAll();
    }

    @GetMapping("/{id}")
    public Product findById( @PathVariable  Long id) {
        return productServicePort.findById(id);
    }

    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productServicePort.createProduct(product);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productServicePort.updateProduct(id, product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        return productServicePort.deleteProduct(id);
    }


}
