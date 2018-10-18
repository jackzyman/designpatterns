package Tour;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleTourTest {
    @Test
    public void testReservedSeats(){
        SingleTour singleTour = new SingleTour("Cicada Market", 300, 15);
        singleTour.reservedSeats(20);
        assertEquals(20, singleTour.getAvailableSeats());
    }
}