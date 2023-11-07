package com.OnlineChat.app.service;

import com.OnlineChat.app.data.ChatType;
import com.OnlineChat.app.data.Group;
import com.OnlineChat.app.data.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppService {

    Map<String, User> userMap = new HashMap<>();
    Map<String, Group> userGroup = new HashMap<>();

    public String generateSessionToken(String userName){
        String sessionToken = UUID.randomUUID().toString();
        User user = new User(userName, ChatType.IDEAL,"");
        userMap.put(sessionToken,user);
        return sessionToken;

    }

    public void createGroup(String sessionId){
        User user = userMap.get(sessionId);
        user.setChatType(ChatType.WAITING);


    }

    public void match(){
        User user1 = null;
        User user2 = null;
        try {
             user1 = userMap.values().stream()
                    .filter(e -> e.getChatType().equals(ChatType.WAITING)).findFirst().get();
            user1.setChatType(ChatType.INCHAT);
             user2 = userMap.values().stream()
                    .filter(e -> e.getChatType().equals(ChatType.WAITING)).findFirst().get();
            user2.setChatType(ChatType.INCHAT);
        }catch (NoSuchElementException ex){
            user1.setChatType(ChatType.WAITING);
            user2.setChatType(ChatType.WAITING);
            throw new RuntimeException("No users to match");
        }
        Group group = new Group(user1,user2,new ArrayList<>(),UUID.randomUUID().toString());
        userGroup.put(group.getGroupid(),group);
        user1.setGroupId(group.getGroupid());
        user2.setGroupId(group.getGroupid());


    }

    public List<String> fetchMessages(String sessionId){
        String groupId = userMap.get(sessionId).getGroupId();
        return userGroup.get(groupId).getMessages();

    }
    public void postMessage(String sessionId,String message){
        User user = userMap.get(sessionId);
        String groupId = user.getGroupId();
        if(user.getGroupId().isEmpty()){
            throw new RuntimeException("user not matched");
        }
        Group group = userGroup.get(groupId);
        group.getMessages().add(user.getName()+": "+message);

    }

}
