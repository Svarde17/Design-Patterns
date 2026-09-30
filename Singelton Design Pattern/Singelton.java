// Singleton: only one instance exists throughout the application
class SingeltonDesignPattern {

    private SingeltonDesignPattern() {}

    // volatile ensures visibility across threads
    private static volatile SingeltonDesignPattern instance;

    // Double-checked locking for thread-safe lazy initialization
    public static SingeltonDesignPattern getInstance() {
        if (instance == null) {
            synchronized (SingeltonDesignPattern.class) {
                if (instance == null) {
                    instance = new SingeltonDesignPattern();
                }
            }
        }
        return instance;
    }
}

class Singelton {
    public static void main(String[] args) {
        SingeltonDesignPattern s1 = SingeltonDesignPattern.getInstance();
        SingeltonDesignPattern s2 = SingeltonDesignPattern.getInstance();

        System.out.println(s1 == s2); // true — same instance
    }
}
