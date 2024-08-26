package com.royal.mongo.repository;

import com.royal.mongo.model.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDO, Integer> {

}
