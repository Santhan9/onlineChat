package com.OnlineChat.app.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    String name;
    ChatType chatType;
    String groupId;
}
