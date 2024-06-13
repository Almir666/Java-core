package DesignPatterns.Prototype.TestPrototype;

import java.util.ArrayList;
import java.util.List;

public class Friends implements Cloneable{
    private List<String> friendsList;

    public Friends() {
        friendsList = new ArrayList<String>();
    }

    public Friends(List<String> friends) {
        this.friendsList = friends;
    }

    public void loadData() {
        friendsList.add("Geyorgiy");
        friendsList.add("Boychick");
        friendsList.add("Sharky");
        friendsList.add("Yourchick");
    }
    public List<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(String newFriend) {
        this.friendsList.add(newFriend);
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for (String s : this.getFriendsList()) {
            temp.add(s);
        }
        return new Friends(temp);
    }
}
