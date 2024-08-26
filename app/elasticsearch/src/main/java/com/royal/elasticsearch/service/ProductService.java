package com.royal.elasticsearch.service;

import com.royal.elasticsearch.dto.Product;
import com.royal.elasticsearch.model.ProductDO;
import com.royal.elasticsearch.repository.ProductRepository;
import com.royal.utils.SampleUtils;
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

        return SampleUtils.copyProperties(productDO, Product.class);
    }

    public void save(Product product) {
        ProductDO productDO = SampleUtils.copyProperties(product, ProductDO.class);
        if (productDO != null) {
            productRepository.save(productDO);
        }
    }

    public List<Product> search(String keyword) {
        List<ProductDO> productDOList = productRepository.findByNameContaining(keyword);

        return productDOList.stream()
                .map(p -> SampleUtils.copyProperties(p, Product.class))
                .collect(Collectors.toList());
    }
}
