package com.digitaltrio.listdoapi.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class NewUserListRequest {
    String listName;
    String ownerID;
}
