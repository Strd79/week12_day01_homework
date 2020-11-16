package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor1 = new Visitor(13, 150.5, 25.00);
        visitor2 = new Visitor(10, 146.0, 15.00);
        visitor3 = new Visitor(12, 144.0, 25.00);
        visitor4 = new Visitor(9, 135.0, 15.00);
        visitor5 = new Visitor(17, 202.0, 65.00);
    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRideDueToAgeAndHeight() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void cannotRideDueToAge() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void cannotRideDueToHeight() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void cannotRideDueToAgeAndHeight() {
        assertEquals(false, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void chargesOver200CmDouble() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor5), 0.01);
    }

    @Test
    public void doesNotChargeDoubleForUnder200() {
        assertEquals(8.40, rollerCoaster.priceFor(visitor4),0.01);
    }
}
