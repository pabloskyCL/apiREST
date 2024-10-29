package com.apiRest.pabloq.apiREST.Controllers;

import com.apiRest.pabloq.apiREST.Entities.Product;
import com.apiRest.pabloq.apiREST.Respositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private IProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(() -> {
            throw  new RuntimeException("No se encontro el producto con el id" + id);
        });
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product productInfo) {
        Product product = productRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("No se encontro el producto con el id" + id);
        });
        product.setName(productInfo.getName());
        product.setPrice(productInfo.getPrice());

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        if(!productRepository.existsById(id)){
            throw new RuntimeException("No se encontro el producto con el id " + id);
        };
        productRepository.deleteById(id);

        return "El producto ha sido eliminado";
    }


}
