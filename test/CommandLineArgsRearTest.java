import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class CommandLineArgsRearTest {
    @Test
    public void testGetNmaeFormatterGivesTheRespectiveNameFormatterAccordingToProvidedOptionForAddressing() {
        String [] args = {"--informal","records"};
        CommandLineArgsRear commandLineArgsRear = new CommandLineArgsRear(args);
        InformalName informalName = new InformalName();
        assertEquals(informalName,commandLineArgsRear.getNameFormatter());

        String [] anotherArgs = {"--formal","records"};
        CommandLineArgsRear anotherCommandLineArgsRear = new CommandLineArgsRear(anotherArgs);
        FormalName formalName = new FormalName();
        assertEquals(formalName,anotherCommandLineArgsRear.getNameFormatter());
    }

    @Test
    public void testGetFilterGiveAllFilterAccordingToProvidedOptionForFilter() {
        String [] args = {"--informal","records","--filterCountry_Bangladesh","--filterAge_21"};
        CommandLineArgsRear commandLineArgsRear = new CommandLineArgsRear(args);
        CountryFilter countryFilter = new CountryFilter();
        countryFilter.addConstrain("Bangladesh");
        AgeFilter ageFilter = new AgeFilter();
        ageFilter.addConstrain(21);
        LinkedList<Filter> filters=  commandLineArgsRear.getFilters();
        assertEquals(countryFilter,filters.get(0));
        assertEquals(ageFilter,filters.get(1));
    }

    @Test
    public void testGetFilesNameGiveAllTheProvidedFilesName(){
        String [] args = {"--informal","records","--filterCountry_Bangladesh","--filterAge_21"};
        CommandLineArgsRear commandLineArgsRear = new CommandLineArgsRear(args);
        LinkedList<String> files =  commandLineArgsRear.getFilesName();
        assertEquals("records",files.get(0));
    }
}