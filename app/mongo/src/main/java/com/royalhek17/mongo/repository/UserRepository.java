package com.royalhek17.mongo.repository;

import com.royalhek17.mongo.model.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserDO, Integer> {

}
