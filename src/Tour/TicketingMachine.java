package Tour;

import java.util.ArrayList;
import java.util.List;

public class TicketingMachine implements Tour {
    ArrayList<Tour> allTours = new ArrayList<Tour>();
    private Tour currentTour;
    private double payment;
    private double change;
    List<Tour> tours = new ArrayList<Tour>();

    public TicketingMachine() {
        Tour cicadaMarket = new SingleTour("Cicada Market", 300, 15);
        Tour phromThepCape = new SingleTour("Phrom Thep Cape", 1000, 10);
        allTours.add(cicadaMarket);
        allTours.add(phromThepCape);


        tours.add(cicadaMarket);
        tours.add(phromThepCape);

        Tour bothTour = new PackageTour("Market & Cape", tours);
        allTours.add(bothTour);
    }

    public void setCurrentTour(String name) {
        if (name == null) {
            this.currentTour = null;
        }
        else {
            String[] tmp;
            for (Tour t : allTours) {
                tmp = t.getName().split("\\n");
                if (name.equals(tmp[0])) {
                    this.currentTour = t;
                    break;
                }
            }
            this.payment = this.currentTour.getPrice();
            this.change = 0;

        }
    }

    public void pay(double money){
        this.payment -= money;
        if (this.payment < 0){
            this.change -= this.payment;
            this.payment = 0;
        }
    }

    public Tour getCurrentTour() {
        return currentTour;
    }

    public double getPayment() {
        return payment;
    }

    public double getChange() {
        return change;
    }

    @Override
    public String getName() {
        String tmp = "";
        for (Tour t: allTours) tmp += t.getName() + "\n";
        return tmp;
    }

    @Override
    public double getPrice() {
        return this.currentTour.getPrice();
    }

    @Override
    public int getAvailableSeats() {
        return this.currentTour.getAvailableSeats();
    }
}
