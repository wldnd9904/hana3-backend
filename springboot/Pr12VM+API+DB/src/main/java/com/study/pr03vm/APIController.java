package com.study.pr03vm;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class APIController {
    ProductRepository productRepository;

    @GetMapping("/get")
    public ProductResult get(@RequestParam long id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            ProductEntity product = optional.get();
            return new ProductResult("ok", optional.get().getId(), optional.get().getName(), product.getPrice(), product.getLimitDate());
        }
        return new ProductResult("fail", 0L, null, 0, null);
    }

    @GetMapping("/products")
    public List<ProductEntity> index() {
        return productRepository.findAll();
    }

    @PostMapping("/new")
    public Result newItem(@RequestBody ProductRequest product) {
        productRepository.save(product.toProductEntity());
        return new Result("ok", "");
    }

    @PostMapping("/edit")
    public Result edit(@RequestBody ProductRequest product) {
        productRepository.updateProduct(product.id(), product.name(), product.price(), product.limit_date());
        return new Result("ok", "");
    }

    @DeleteMapping("/remove")
    public Result remove(@RequestParam long id) {
        productRepository.deleteById(id);
        return new Result("ok", "");
    }
}
