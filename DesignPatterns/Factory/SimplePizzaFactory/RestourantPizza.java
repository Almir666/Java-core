package DesignPatterns.Factory.SimplePizzaFactory;

public class RestourantPizza {
    private final PizzaFactory pizzaShop;

    public RestourantPizza(PizzaFactory pizzaShop) {
        this.pizzaShop = pizzaShop;
    }
    public Pizza orderPizza(PizzaType type) {
        Pizza pizza = pizzaShop.makePizza(type);
        pizza.rollOutTheDough();
        pizza.putTheFilling();
        pizza.bakePizza();

        System.out.println("Ваша " + pizza.getName() + " готова!");
        return pizza;
    }

    public static void main(String[] args) {
        PizzaFactory factory = new PizzaFactory();
        RestourantPizza pizzaOverLord = new RestourantPizza(factory);

        pizzaOverLord.orderPizza(PizzaType.PEPPERONI);
    }
}
