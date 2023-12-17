package com.digitaltrio.listdoapi.domain.entities;

import com.digitaltrio.listdoapi.domain.requests.NewUserRequest;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document("users")
public class User {

    @Id
    private String id;

    private String username;
    private String email;
    private String password;
    private LocalDateTime created_at;
    List<UserList> lists;

    public User(NewUserRequest newUserRequest) {
        this.username = newUserRequest.getUsername();
        this.email = newUserRequest.getEmail();
        this.password = newUserRequest.getPassword();
        this.created_at = LocalDateTime.now();
    }
}