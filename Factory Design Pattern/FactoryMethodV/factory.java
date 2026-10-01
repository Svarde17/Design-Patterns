package FactoryMethodV;
abstract class Burger {
    abstract void prepare();
}

// SahilBurger products
class Basic extends Burger {
    @Override
    void prepare() { System.out.println("SahilBurger: Preparing Basic burger"); }
}

class Standard extends Burger {
    @Override
    void prepare() { System.out.println("SahilBurger: Preparing Standard burger"); }
}

class Premium extends Burger {
    @Override
    void prepare() { System.out.println("SahilBurger: Preparing Premium burger"); }
}

// VardeBurger products (wheat based)
class BasicWheat extends Burger {
    @Override
    void prepare() { System.out.println("VardeBurger: Preparing Basic Wheat burger"); }
}

class StandardWheat extends Burger {
    @Override
    void prepare() { System.out.println("VardeBurger: Preparing Standard Wheat burger"); }
}

class PremiumWheat extends Burger {
    @Override
    void prepare() { System.out.println("VardeBurger: Preparing Premium Wheat burger"); }
}

// Abstract factory - subclasses override createBurger() to return their own burger types
abstract class BurgerFactory {
    abstract Burger createBurger(String type);

    // template method - calls createBurger() internally
    public Burger orderBurger(String type) {
        Burger burger = createBurger(type);
        burger.prepare();
        return burger;
    }
}

// Concrete factory for SahilBurger
class SahilBurger extends BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "basic":    return new Basic();
            case "standard": return new Standard();
            case "premium":  return new Premium();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}

// Concrete factory for VardeBurger
class VardeBurger extends BurgerFactory {
    @Override
    public Burger createBurger(String type) {
        switch (type) {
            case "basic":    return new BasicWheat();
            case "standard": return new StandardWheat();
            case "premium":  return new PremiumWheat();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}

class Main {
    public static void main(String[] args) {
        BurgerFactory sahil = new SahilBurger();
        sahil.orderBurger("basic");
        sahil.orderBurger("standard");
        sahil.orderBurger("premium");

        System.out.println();

        BurgerFactory varde = new VardeBurger();
        varde.orderBurger("basic");
        varde.orderBurger("standard");
        varde.orderBurger("premium");
    }
}
