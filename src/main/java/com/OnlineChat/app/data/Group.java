package com.OnlineChat.app.data;

import java.util.List;

public class Group {
    User user1;
    User user2;
    List<String> messages;
    String groupid;

    public Group(User user1, User user2, List<String> messages, String groupid) {
        this.user1 = user1;
        this.user2 = user2;
        this.messages = messages;
        this.groupid = groupid;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }
}
