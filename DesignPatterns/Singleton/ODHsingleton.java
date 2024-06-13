package DesignPatterns.Singleton;

public class ODHsingleton {
    public static class SingletonHolder {
		public static final ODHsingleton HOLDER_INSTANCE = new ODHsingleton();
	}
		
	public static ODHsingleton getInstance() {
		return SingletonHolder.HOLDER_INSTANCE;
	}
    // On Demand Holder
    // + Ленивая инициализация
    // + Высокая производительность
    // - Невозможно использовать для не статических полей класса
}
