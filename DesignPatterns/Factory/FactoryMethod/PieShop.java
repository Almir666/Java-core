package DesignPatterns.Factory.FactoryMethod;

public class PieShop extends BakerShop{
    @Override
    protected Bakery createBake(BakeryType type) {
        Bakery bake = null;
        switch (type) {
            case APPLE_PIE:
                bake = new ApplePie();
                break;
            case CHICKEN_PIE:
                bake = new ChickenPie();
                break;
            case FISH_PIE:
                bake = new FishPie();
                break;
            default:
                break; 
        }
        return bake;
    }
}
