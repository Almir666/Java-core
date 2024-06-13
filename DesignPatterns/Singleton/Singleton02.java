package DesignPatterns.Singleton;

public class Singleton02 {
    private final static Singleton02 instance = new Singleton02();
    private String state;
    
    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        return instance;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
