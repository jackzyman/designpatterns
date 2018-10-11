package AdapterPattern;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        simulator.simulate();
    }

    void simulate(){
        Quackable mallardDuck = new MallardDuck();
        Quackable redheadDuck = new RedheadDuck();
        Quackable rubberDuck = new RubberDuck();
        Quackable duckCall = new DuckCall();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        System.out.println("\nDuck Simulator: With Goose&Pigeon Adapter");

        simulate(mallardDuck);
        simulate(redheadDuck);
        simulate(rubberDuck);
        simulate(duckCall);
        simulate(gooseDuck);
        simulate(pigeonDuck);
    }

    void simulate(Quackable duck){
        duck.quack();
    }

}
