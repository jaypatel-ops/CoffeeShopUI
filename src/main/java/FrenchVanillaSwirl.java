
public class FrenchVanillaSwirl extends CoffeeDecorator {

    private double cost = .75;
    FrenchVanillaSwirl(Coffee specialCoffee) { super(specialCoffee); }

    public double makeCoffee(){return specialCoffee.makeCoffee() + addFrenchVanillaSwirl(); }

    private double addFrenchVanillaSwirl(){

        System.out.println(" + French Vanilla Swirl: $"+ cost);

        return cost;

    }
}
