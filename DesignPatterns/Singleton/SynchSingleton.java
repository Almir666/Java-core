package DesignPatterns.Singleton;

public class SynchSingleton {
    private static SynchSingleton instance;
    
    public static synchronized SynchSingleton getInstance() {
        if (instance == null) {
            instance = new SynchSingleton();
        }
        return instance;
    }
    // Synchronized
    // + Ленивая инициализация
    // - Низкая производительность
}
