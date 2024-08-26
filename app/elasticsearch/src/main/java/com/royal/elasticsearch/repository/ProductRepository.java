package com.royal.elasticsearch.repository;

import com.royal.elasticsearch.model.ProductDO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ElasticsearchRepository<ProductDO, Integer> {
    List<ProductDO> findByNameLike(String name);
    List<ProductDO> findByNameContaining(String name);
}
