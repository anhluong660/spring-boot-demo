package com.royalhek17.elasticsearch.service;

import com.royalhek17.elasticsearch.dto.Product;
import com.royalhek17.elasticsearch.model.ProductDO;
import com.royalhek17.elasticsearch.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(int id) {
        ProductDO productDO = productRepository.findById(id).orElse(null);
        if (productDO == null) {
            return null;
        }

        Product product = new Product();
        BeanUtils.copyProperties(productDO, product);

        return product;
    }

    public void save(Product product) {
        ProductDO productDO = new ProductDO();
        BeanUtils.copyProperties(product, productDO);
        productRepository.save(productDO);
    }

    public List<Product> search(String keyword) {
        List<ProductDO> productDOList = productRepository.findByNameContaining(keyword);

        return productDOList.stream()
                .map(p -> {
                    Product product = new Product();
                    BeanUtils.copyProperties(p, product);
                    return product;
                })
                .collect(Collectors.toList());
    }
}
