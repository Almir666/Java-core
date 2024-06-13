package DesignPatterns.Factory.FactoryMethod;

public class MyBakery {
    public static void main(String[] args) {
        PieShop pieShop = new PieShop();
        pieShop.orderBake(BakeryType.APPLE_PIE);

        PizzaShop pizzaShop = new PizzaShop();
        pizzaShop.orderBake(BakeryType.FOUR_CHEESES);
    }
}
