package DesignPatterns.Factory.FactoryMethod;

public class PizzaShop extends BakerShop{
    @Override
    protected Bakery createBake(BakeryType type) {
        Bakery bake = null;
        switch (type) {
            case PEPPERONI:
                bake = new Pepperoni();
                break;
            case FOUR_CHEESES:
                bake = new FourCheeses();
                break;
            case HAWAIIAN:
                bake = new Hawaiian();
                break;
            default:
                break;    
        }
        return bake;
    }
}
