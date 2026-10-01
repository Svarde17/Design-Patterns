// Simple Factory Design Pattern
// Centralizes object creation logic so the client doesn't need to know which class to instantiate

// Abstract product - defines the contract for all burger types
abstract class Burger {
    abstract void prepare();
}

// Concrete products - each burger type implements its own preparation
class Basic extends Burger {
    @Override
    void prepare() {
        System.out.println("Preparing basic burger");
    }
}

class Standard extends Burger {
    @Override
    void prepare() {
        System.out.println("Preparing standard burger");
    }
}

class Premium extends Burger {
    @Override
    void prepare() {
        System.out.println("Preparing premium burger with extra toppings");
    }
}

// Factory - decides which object to create based on the type passed
class BurgerFactory {
    public static Burger getBurger(String type) {
        if (type.equals("basic")) {
            return new Basic();
        }
        if (type.equals("standard")) {
            return new Standard();
        }
        if (type.equals("premium")) {
            return new Premium();
        }
        // throws exception for unknown types instead of returning null
        throw new IllegalArgumentException("Unknown burger type: " + type);
    }
}

class Main {
    public static void main(String[] args) {
        Burger b1 = BurgerFactory.getBurger("basic");
        b1.prepare();

        Burger b2 = BurgerFactory.getBurger("standard");
        b2.prepare();

        Burger b3 = BurgerFactory.getBurger("premium");
        b3.prepare();

        // test invalid type - should throw IllegalArgumentException
        try {
            BurgerFactory.getBurger("unknown");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
