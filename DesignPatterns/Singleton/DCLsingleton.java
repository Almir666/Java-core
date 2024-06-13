package DesignPatterns.Singleton;

public class DCLsingleton {
    private static volatile DCLsingleton instance;

    public static DCLsingleton getInstance() {
        DCLsingleton localInstance = instance;
        if (localInstance == null) {
            synchronized(DCLsingleton.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DCLsingleton();
                }
            }
        }
        return localInstance;
    }
    // Double Checked Lock
    // + Ленивая инициализация
    // + Высокая производительность
}
