package CompositePattern;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
        AbstractDuckFactory duckCountingFactory = new CountingDuckFactory();
        simulator.simulate(duckCountingFactory);

    }

    void simulate(AbstractDuckFactory duckFactory){
        Quackable redheadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseDuck = new GooseAdapter(new Goose());
        Quackable pigeonDuck = new PigeonAdapter(new Pigeon());

        Flock flockOfDuck = new Flock();
        flockOfDuck.add(redheadDuck);
        flockOfDuck.add(duckCall);
        flockOfDuck.add(rubberDuck);
        flockOfDuck.add(gooseDuck);
        flockOfDuck.add(pigeonDuck);

        System.out.println("\nDuck Simulator: Whole Flock Simulation");
        simulate(flockOfDuck);


        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times" + "\n");
    }

    void simulate(Quackable duck){
        duck.quack();
    }

}
