/**
 * Strategy Design Pattern - Robot Simulation
 *
 * Intent:
 *   Define a family of algorithms (strategies), encapsulate each one as an interface,
 *   and make them interchangeable at runtime without changing the client (Robot).
 *
 * Structure:
 *   - Strategy interfaces : Walkable, Flyable, Talkable (and optionally Projectable)
 *   - Concrete strategies : NormalWalk, NotNormalWalk, NormalFly, NotNormalFly, NormalTalk, NotNormalTalk
 *   - Context             : Robot (holds references to strategy interfaces)
 *
 * NOTE on projection():
 *   Currently, projection() is hardcoded inside Robot because it is the same for all robots.
 *   However, if robots need different projection behaviors in the future, you can extract it
 *   into a separate "Projectable" interface and inject it via composition — just like Walkable,
 *   Flyable, and Talkable. Example:
 *
 *       interface Projectable { void project(); }
 *       class NormalProjection implements Projectable {
 *           public void project() { System.out.println("Normal projection!"); }
 *       }
 *       // Then in Robot: Projectable p; and call r.p = new NormalProjection();
 */

// Context class — holds strategy references and delegates behavior to them
class Robot {
    Talkable t;   // talk strategy
    Walkable w;   // walk strategy
    Flyable f;    // fly strategy

    // Hardcoded because projection is constant across all robots.
    // Can be made a Projectable strategy interface if variation is needed in future.
    void projection() {
        System.out.println("Make a simulation of Robot!");
    }
}

// ─── Walk Strategy ───────────────────────────────────────────────────────────

// Strategy interface for walking behavior
interface Walkable {
    void walk();
}

// Concrete strategy: normal walking
class NormalWalk implements Walkable {
    public void walk() {
        System.out.println("Robot is walking normally!");
    }
}

// Concrete strategy: abnormal walking
class NotNormalWalk implements Walkable {
    public void walk() {
        System.out.println("Robot is walking not normally!");
    }
}

// ─── Fly Strategy ────────────────────────────────────────────────────────────

// Strategy interface for flying behavior
interface Flyable {
    void fly();
}

// Concrete strategy: normal flying
class NormalFly implements Flyable {
    public void fly() {
        System.out.println("Robot is flying normally!");
    }
}

// Concrete strategy: abnormal flying
class NotNormalFly implements Flyable {
    public void fly() {
        System.out.println("Robot is flying not normally!");
    }
}

// ─── Talk Strategy ───────────────────────────────────────────────────────────

// Strategy interface for talking behavior
interface Talkable {
    void talk();
}

// Concrete strategy: normal talking
class NormalTalk implements Talkable {
    public void talk() {
        System.out.println("Robot is talking normally!");
    }
}

// Concrete strategy: abnormal talking
class NotNormalTalk implements Talkable {
    public void talk() {
        System.out.println("Robot is talking not normally!");
    }
}

// ─── Client ──────────────────────────────────────────────────────────────────

class RobotStimulation {
    public static void main(String[] args) {

        Robot r = new Robot();
        r.projection();

        // Assign normal strategies at runtime
        r.t = new NormalTalk();
        r.t.talk();
        r.w = new NormalWalk();
        r.w.walk();
        r.f = new NormalFly();
        r.f.fly();

        System.out.println("Now, the robot is not normal!");

        // Swap strategies at runtime — core benefit of Strategy Pattern
        r.t = new NotNormalTalk();
        r.t.talk();
        r.w = new NotNormalWalk();
        r.w.walk();
        r.f = new NotNormalFly();
        r.f.fly();
    }
}
