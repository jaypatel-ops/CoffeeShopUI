
public class AlmondMilk extends CoffeeDecorator {

    private double cost = 1.0;
    AlmondMilk(Coffee specialCoffee) { super(specialCoffee); }

    public double makeCoffee(){return specialCoffee.makeCoffee() + addAlmondMilk(); }

    private double addAlmondMilk(){

        System.out.println(" + Almond Milk: $"+ cost);

        return cost;

    }
}
