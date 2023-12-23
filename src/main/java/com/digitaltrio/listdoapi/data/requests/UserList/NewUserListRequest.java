package com.digitaltrio.listdoapi.data.requests.UserList;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class NewUserListRequest {
    String listName;
    String ownerID;
}
