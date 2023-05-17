# Decorator Pattern

The Decorator pattern is a structural design pattern that allows behavior to be added to an individual object dynamically, without affecting the behavior of other objects from the same class.

## Intent
The intent of the Decorator pattern is to provide a flexible way to extend the functionality of an object at runtime by wrapping it with additional behavior.

## Problem
In some scenarios, it becomes necessary to add new functionality or modify the behavior of an existing object without altering its structure or affecting other instances of the same class. Traditional approaches such as subclassing can quickly lead to a large number of subclasses and code duplication.

## Solution
The Decorator pattern suggests wrapping an object with one or more decorator objects that provide additional functionality. The decorators implement the same interface as the wrapped object and contain a reference to the wrapped object. This allows the decorators to transparently add new behavior before or after the execution of the wrapped object's methods.

To implement the Decorator pattern, the following components are typically involved:
- **Component**: The interface or abstract class that defines the common interface for both the concrete component and decorators.
- **Concrete Component**: The original object to which new behavior will be added.
- **Decorator**: An abstract class or interface that defines the common interface for all decorators. It holds a reference to the component and delegates the requests to it.
- **Concrete Decorators**: Concrete subclasses of the decorator class that add specific behavior or modify the behavior of the component.

![Structure](../image/structure.png)
![Notification Example](../image/notification-example.png)

## Pros and Cons

### Pros
- **Dynamic behavior extension**: Decorators provide a flexible way to extend an object's behavior at runtime by adding or modifying functionality.
- **Single Responsibility Principle**: The Decorator pattern allows functionality to be divided among multiple classes, each with a specific responsibility.
- **Open for extension, closed for modification**: The pattern allows new decorators to be added without modifying the existing code, ensuring compatibility with existing code.

### Cons
- **Complexity**: The use of decorators can introduce additional complexity, as multiple decorator layers may need to be added to achieve the desired behavior.
- **Ordering of decorators**: The order in which decorators are applied can be important. Care must be taken to ensure that decorators are applied in the correct order to achieve the desired behavior.
- **Potential performance impact**: The use of decorators may introduce a slight overhead due to the additional indirection and delegation involved.

## Example
Here's an example code snippet that demonstrates the Decorator pattern in Java. Let's consider a `Pizza` interface and its concrete implementation. We'll then create decorators to add toppings to the pizza dynamically.

```java
// Component interface
public interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete component
public class Margherita implements Pizza {
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
public abstract class PizzaDecorator implements Pizza {
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
public class CheeseDecorator extends PizzaDecorator {
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

public class TomatoDecorator extends PizzaDecorator {
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

// Usage
public class PizzaShop {
    public static void main(String[] args) {
        Pizza margherita = new Margherita();
        Pizza cheeseMargherita = new CheeseDecorator(margherita);
        Pizza deluxePizza = new TomatoDecorator(new CheeseDecorator(margherita));

        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());
        System.out.println(cheeseMargherita.getDescription() + " - Cost: $" + cheeseMargherita.getCost());
        System.out.println(deluxePizza.getDescription() + " - Cost: $" + deluxePizza.getCost());
    }
}
```

In the above example, the `Pizza` interface represents the component, and `Margherita` is the concrete component. The `PizzaDecorator` class is the abstract decorator that implements the common interface and holds a reference to the component. The `CheeseDecorator` and `TomatoDecorator` are concrete decorators that add additional behavior to the pizza by extending the `PizzaDecorator` class.

By using decorators, we can dynamically add toppings to the base pizza at runtime, allowing for flexibility and modularity.


 

