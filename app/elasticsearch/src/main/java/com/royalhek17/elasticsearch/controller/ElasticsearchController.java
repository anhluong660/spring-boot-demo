package com.royalhek17.elasticsearch.controller;

import com.royalhek17.elasticsearch.dto.Product;
import com.royalhek17.elasticsearch.service.ProductService;
import com.royalhek17.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elasticsearch")
public class ElasticsearchController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Response<Product> getProductById(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            return Response.error("Not found");
        } else {
            return Response.success(product);
        }
    }

    @PostMapping("/add-product")
    public Response<Product> addNewProduct(@RequestBody Product product) {
        productService.save(product);
        return Response.success(product);
    }

    @GetMapping("search/{keyword}")
    public Response<List<Product>> search(@PathVariable String keyword) {
        List<Product> products = productService.search(keyword);
        return Response.success(products);
    }
}
