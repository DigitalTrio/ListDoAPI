package com.digitaltrio.listdoapi.domain.entities;

import com.digitaltrio.listdoapi.data.requests.UserList.NewUserListRequest;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Document("lists")
public class UserList {
    @Id
    private String id;
    private String listName;
    @CreatedDate
    private LocalDateTime created_at;
    private String owner_id;
    List<User> members;

    public UserList(NewUserListRequest newUserListRequest) {
        this.listName = newUserListRequest.getListName();
        this.owner_id = newUserListRequest.getOwnerID();
    }
}
