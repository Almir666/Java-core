package DesignPatterns.Factory.FactoryMethod;

public abstract class BakerShop {
    public Bakery orderBake(BakeryType type) {
        Bakery bake = createBake(type);

        bake.makeSomeBaking();
        
        System.out.println("Ваш заказ, " + bake.getName() + " готов!");
        return bake;
    }
    protected abstract Bakery createBake(BakeryType type);
}
