package DecoratorPattern;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate(){
        Quackable mallardDuck = new QuackCounter(new QuackEcho(new MallardDuck()));
//        Quackable mallardDuck = new QuackEcho(new QuackCounter(new MallardDuck()));
//        quack echo จะถูกนับอีกรอบ
        Quackable redheadDuck = new QuackCounter(new QuackEcho(new RedheadDuck()));
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(duckCall);
        simulate(gooseDuck);
        simulate(pigeonDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
    }

    void simulate(Quackable duck){
        duck.quack();
    }

}
