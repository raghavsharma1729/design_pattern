package StructuralPattern.Decorator;

// Component interface
interface Pizza {
    String getDescription();

    double getCost();
}

// Concrete component
class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita";
    }

    @Override
    public double getCost() {
        return 6.99;
    }
}

// Decorator
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription();
    }

    @Override
    public double getCost() {
        return pizza.getCost();
    }
}

// Concrete decorators
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.50;
    }
}

class TomatoDecorator extends PizzaDecorator {
    public TomatoDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Tomato";
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.75;
    }
}

public class PizzaExample {
    public static void main(String[] args) {
        Pizza margherita = new Margherita();
        Pizza cheeseMargherita = new CheeseDecorator(margherita);
        Pizza deluxePizza = new TomatoDecorator(new CheeseDecorator(margherita));

        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());
        System.out.println(cheeseMargherita.getDescription() + " - Cost: $" + cheeseMargherita.getCost());
        System.out.println(deluxePizza.getDescription() + " - Cost: $" + deluxePizza.getCost());
    }
}
