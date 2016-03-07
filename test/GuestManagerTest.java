import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;


public class GuestManagerTest {
    @Test
    public void testGuestManagerGeneratesInformalLevelAccordingToGivenData() {
        String[] gusestDetails = new String[2];
        gusestDetails[0] = "Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia";
        gusestDetails[1] = "Freddy,Vandervort,Male,36,Crooks ton,North Carolina,Bangladesh";
        GuestManager guestManager = new GuestManager(new InformalName(), gusestDetails);
        guestManager.generateGuestList();
        LinkedList<String> lebels = guestManager.generateLevel();
        assertEquals("Mr Catharine Hills", lebels.get(0));
        assertEquals("Mr Freddy Vandervort", lebels.get(1));
    }

    @Test
    public void testGuestManagerGeneratesFormalLevelAccordingToGivenData() {
        String[] gusestDetails = new String[2];
        gusestDetails[0] = "Catharine,Hills,Male,20,West Shanna,South Carolina,Macedonia";
        gusestDetails[1] = "Freddy,Vandervort,Male,36,Crooks ton,North Carolina,Bangladesh";
        GuestManager guestManager = new GuestManager(new FormalName(), gusestDetails);
        guestManager.generateGuestList();
        LinkedList<String> lebels = guestManager.generateLevel();
        assertEquals("Mr Hills, Catharine", lebels.get(0));
        assertEquals("Mr Vandervort, Freddy", lebels.get(1));
    }

    @Test
    public void testGuestManagerCanGenerateLevelForOnlySpecificCountry() {
        LinkedList<Filter> filter = new LinkedList<>();
        CountryFilter countryFilter = new CountryFilter();
        countryFilter.addConstrain("Qatar");
        filter.add(countryFilter);
        String[] gusestDetails = new String[6];
        gusestDetails[0] = "Princess,Luettgen,Male,18,Katlynn view,South Carolina,Qatar";
        gusestDetails[1] = "Melissa,Hessel,Male,36,Veda haven,Vermont,Romania";
        gusestDetails[2] = "Jabari,Emmerich,Female,27,Katlynn view,Vermont,Macedonia";
        gusestDetails[3] = "Kallie,Kovacek,Female,35,Katlynn view,Illinois,Qatar";
        gusestDetails[4] = "Jerald,Hudson,Male,31,Crooks ton,Illinois,Macedonia";
        gusestDetails[5] = "Amelia,Abernathy,Male,29,West Shanna,Illinois,Macedonia";
        GuestManager guestManager = new GuestManager(new FormalName(), gusestDetails);
        guestManager.generateGuestList();

        LinkedList<String> lebels = guestManager.generateLevel(filter);
        assertEquals(2,lebels.size());
        assertEquals("Mr Luettgen, Princess, Qatar", lebels.get(0));
        assertEquals("Ms Kovacek, Kallie, Qatar", lebels.get(1));

    }

    @Test
    public void testGuestManagerCanGenerateLevelForOnlySpecificCountryAndPersonAboveGivenAge() {
        LinkedList<Filter> filter = new LinkedList<>();
        CountryFilter countryFilter = new CountryFilter();
        countryFilter.addConstrain("Qatar");
        AgeFilter ageFilter = new AgeFilter();
        ageFilter.addConstrain(30);
        filter.add(countryFilter);
        filter.add(ageFilter);
        String[] gusestDetails = new String[3];
        gusestDetails[0] = "Princess,Luettgen,Male,18,Katlynn view,South Carolina,Qatar";
        gusestDetails[1] = "Kallie,Kovacek,Female,35,Katlynn view,Illinois,Qatar";
        gusestDetails[2] = "Amelia,Abernathy,Male,29,West Shanna,Illinois,Macedonia";
        GuestManager guestManager = new GuestManager(new FormalName(), gusestDetails);
        guestManager.generateGuestList();

        LinkedList<String> lebels = guestManager.generateLevel(filter);
        assertEquals(1,lebels.size());
        assertEquals("Ms Kovacek, Kallie, Qatar, 35", lebels.get(0));

    }
}