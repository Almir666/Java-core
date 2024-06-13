package Lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerExample {
        public static ArrayList<Car> carCreater(Supplier<Car> carSupplier) {
        ArrayList<Car> al = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            al.add(carSupplier.get());
        }
        return al; 
    }
    // Создаем метод котрый будет менять свойства машины
    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);

    } 
    public static void main(String[] args) {
        // Создаем лист из трех машин используя предикат
        ArrayList<Car> cars = carCreater(() -> new Car("Nissan", "Black", 1.6));
        
        // Передаем в наш метод машину из списка под 0 индексом, дальше меняем свойства на новые,
        // и Consumer потребляет нашу машину и изменяет ее свойства
        changeCar(cars.get(0), car -> {
            car.model = "Mazda";
            car.color = "White";
            car.engine = 2.4;
        });

        System.out.println(cars);
    }
}

class Car {
    String model;
    String color;
    Double engine;

    public Car(String model, String color, Double engine) {
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ". Цвет: " + color + ". Двигатель: " + engine;
    }
    
}
