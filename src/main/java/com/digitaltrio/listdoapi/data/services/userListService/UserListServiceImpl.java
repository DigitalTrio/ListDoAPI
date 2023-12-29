package com.digitaltrio.listdoapi.data.services.userListService;

import com.digitaltrio.listdoapi.data.repositories.UserListRepository;
import com.digitaltrio.listdoapi.data.requests.UserList.NewUserListRequest;
import com.digitaltrio.listdoapi.data.requests.user.NewUserRequest;
import com.digitaltrio.listdoapi.data.services.userService.UserServiceImpl;
import com.digitaltrio.listdoapi.domain.controller.UserController;
import com.digitaltrio.listdoapi.domain.entities.UserList;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserListServiceImpl implements UserListService {
    Logger logger = LoggerFactory.getLogger(UserListServiceImpl.class);
    UserListRepository userListRepository;
    UserServiceImpl userService;
    @Autowired
    public UserListServiceImpl(UserListRepository userListRepository, UserServiceImpl userService) {
        this.userListRepository = userListRepository;
        this.userService = userService;
    }

    @Override
    public UserList getList(String listID) throws EntityNotFoundException {
        logger.info("Returned list: " + listID);
        return userListRepository.findById(listID).orElseThrow(() -> new EntityNotFoundException("Couldn't find List with ID: " + listID));
    }

    @Override
    public UserList createList(NewUserListRequest newUserListRequest) throws EntityNotFoundException {
        // Checks if the User with the given OwnerID exists
        if(!userService.userExists(newUserListRequest.getOwnerID())) {
            throw new EntityNotFoundException("Couldn't find User with ID: " + newUserListRequest.getOwnerID());
        }

        UserList userList = new UserList(newUserListRequest);
        logger.info("Created new List: " + userList.getId());
        return userListRepository.save(userList);
    }

    @Override
    public void deleteList(String listID) throws EntityNotFoundException {
        getList(listID);
        userListRepository.deleteById(listID);
    }

    @Override
    public List<UserList> getAllLists() {
        return userListRepository.findAll();
    }

    @Override
    public List<UserList> getAllUserLists(String userID) throws EntityNotFoundException{
        // Checks if the User with the given OwnerID exists
        if(!userService.userExists(userID)) {
            throw new EntityNotFoundException("Couldn't find User with ID: " + userID);
        }
        return userListRepository.findAllByOwnerID(userID);
    }
}
