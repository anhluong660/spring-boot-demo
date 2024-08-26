package com.royal.redis.repository;

import com.royal.redis.model.StorageDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends CrudRepository<StorageDO, Integer> {
}
