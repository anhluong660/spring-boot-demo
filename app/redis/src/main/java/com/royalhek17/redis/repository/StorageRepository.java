package com.royalhek17.redis.repository;

import com.royalhek17.redis.model.StorageDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<StorageDO, Integer> {
}
