import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {
    @Test
    public void testPrintDetailsAsFirstNameFirstGivesTheDetailsAsMrFirstNameSpaceLastNameCommaCountry()  {
        Name name  = new Name("Julius", "Barrows");
        Guest guest = new Guest(name,new Gender("male"),18,new Address("Veda haven","Vermont","Macedonia"));
        name.addNameFormatter(new InformalName());
        assertEquals("Mr Julius Barrows, Macedonia", guest.generateLevel());
    }
    @Test
    public void testPrintDetailsAsLastNameFirstGivesTheDetailsAsMrLastNameCommaFirstNameCommaCountry()  {
        Name name  = new Name("Julius", "Barrows");
        Guest guest = new Guest(name,new Gender("male"),18,new Address("Veda haven","Vermont","Macedonia"));
        name.addNameFormatter(new FormalName());
        assertEquals("Mr Barrows, Julius, Macedonia", guest.generateLevel());
    }


    @Test
    public void testAPersonShouldEqualsToItSelf()  {
        Guest guest = new Guest(new Name("Julius", "Barrows"),new Gender("male"),18,new Address("Veda haven","Vermont","Macedonia"));
        assertEquals(guest, guest);
    }
    @Test
    public void testAPersonIsEqualsToOtherPersonWhenBothOfThemHaveExactlySameDetails()  {
        Guest guestOne = new Guest(new Name("Julius", "Barrows"),new Gender("male"),18,new Address("Veda haven","Vermont","Macedonia"));
        Guest guestTwo = new Guest(new Name("Julius", "Barrows"),new Gender("male"),18,new Address("Veda haven","Vermont","Macedonia"));

        assertEquals(guestOne, guestTwo);
    }
}
