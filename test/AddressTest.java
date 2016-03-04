import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddressTest {
    @Test
    public void testStringRepresentationOfAddressShouldBeAs(){
        Address address = new Address("West Shanna", "Vermont", "Bangladesh");
        assertEquals("City : West Shanna, State : Vermont, Country : Bangladesh",address.toString());
    }
    @Test
    public void testGetCountryNameShouldGivesTheCountryName(){
        Address address = new Address("West Shanna", "Vermont", "Bangladesh");
        assertEquals("Bangladesh",address.getCountryName());
    }
}