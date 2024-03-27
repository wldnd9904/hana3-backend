package com.study.pr03vm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class APIController {
    ArrayList<Product> products;

    APIController(){
        products = new ArrayList<>();
        products.add(new Product("상추버거", 3000, LocalDate.of(2024, 3, 30)));
        products.add(new Product("소고기버거", 1000, LocalDate.of(2024, 3, 26)));
        products.add(new Product("치즈버거", 2000, LocalDate.of(2024, 3, 26)));
    }

    @GetMapping("/get")
    public Product get(@RequestParam int index) {
        return products.get(index);
    }

    @GetMapping("/products")
    public ArrayList<Product> index() {
        return products;
    }

    @PostMapping("/new")
    public Result newItem(@RequestBody Product product) {
        products.add(product);
        return new Result("ok","");
    }

    @PostMapping("/edit")
    public Result edit(@RequestBody ProductWithIndex productWithIndex) {
        products.set(productWithIndex.getIndex(), productWithIndex);
        return new Result("ok","");
    }

    @GetMapping("/remove")
    public Result remove(@RequestParam int index) {
        products.remove(index);
        return new Result("ok","");
    }
}
