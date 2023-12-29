package com.digitaltrio.listdoapi.data.repositories;

import com.digitaltrio.listdoapi.domain.entities.UserList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserListRepository extends MongoRepository<UserList, String> {
    List<UserList> findAllByOwnerID(String ownerID);
}
