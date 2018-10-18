package Tour;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PackageTourTest {
    @Test
    public void testReservedSeats(){
        SingleTour singleTour = new SingleTour("Cicada Market", 300, 15);
        SingleTour singleTour2 = new SingleTour("Phrom Thep Cape", 1000, 10);
        List<Tour> tours = new ArrayList<Tour>();
        tours.add(singleTour);
        tours.add(singleTour2);
        PackageTour packageTour = new PackageTour("Market&Cape", tours);
        packageTour.reservedSeats(50);
        assertEquals(-50, packageTour.getAvailableSeats());
    }

    @Test
    public void testAddTour(){
        SingleTour singleTour = new SingleTour("Cicada Market", 300, 15);
        SingleTour singleTour2 = new SingleTour("Phrom Thep Cape", 1000, 10);
        List<Tour> tours = new ArrayList<Tour>();
        tours.add(singleTour);
        tours.add(singleTour2);
        PackageTour packageTour = new PackageTour("Market&Cape", tours);
        packageTour.addTour(singleTour);
        assertEquals("Market&Cape", packageTour.getName());
    }
}