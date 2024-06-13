package DesignPatterns.Prototype.TestPrototype;

public class PrototypePatternTest {
    public static void main(String[] args) throws Exception {
        Friends friends = new Friends();
        friends.loadData();

        Friends newFriendsList1 = (Friends) friends.clone();
        Friends newFriendsList2 = (Friends) friends.clone();

        newFriendsList1.setFriendsList("Ildareshka");
        newFriendsList2.setFriendsList("Dimka");

        System.out.println("Friend list first: " + friends.getFriendsList());
        System.out.println("Friend list second: " + newFriendsList1.getFriendsList());
        System.out.println("Friend list third: " + newFriendsList2.getFriendsList());
        System.out.println(friends);
        System.out.println(newFriendsList1);
    }
}
