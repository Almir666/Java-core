package DesignPatterns.Factory.SimplePizzaFactory;

public class PizzaFactory {
    public Pizza makePizza(PizzaType type) {
        Pizza pizza = null;
        switch (type) {
            case PEPPERONI:
                pizza = new Pepperoni();
                break;
            case FOUR_CHEESES:
                pizza = new FourCheeses();
                break;      
            case HAWAIIAN:
                pizza = new Hawaiian();
                break;
            default:
                break;
        }
        return pizza;
    }
}
