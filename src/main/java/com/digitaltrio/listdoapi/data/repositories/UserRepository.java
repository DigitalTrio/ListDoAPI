package com.digitaltrio.listdoapi.data.repositories;

import com.digitaltrio.listdoapi.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    long count();
    Optional<User> findUserByEmail(String email);
    Boolean existsByEmail(String email);
}
