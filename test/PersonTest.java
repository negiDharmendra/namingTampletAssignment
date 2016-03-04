import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testDefaultFormatToAdressAPersonisMrOrMsFirstNameSpaceLastName()  {
        Person person = new Person("Dharmendra", "Negi", new Gender("male"));
        assertEquals("Mr Dharmendra Negi",person.getFullName());
    }
    @Test
    public void testChangeTheFormatOfAddressingAPersonWillChangeFormatIfGivenValueISTrue()  {
        Person person = new Person("Dharmendra", "Negi", new Gender("male"));
        person.changeTheFormatOfAddressingAPerson(true);
        assertEquals("Mr Negi, Dharmendra",person.getFullName());
    }
    @Test
    public void testSetAgeShouldAllowsToSetAPersonAge()  {
        Person person = new Person("Jone", "Carter", new Gender("male"));
        person.setAge(26);
        assertEquals(26,person.getAge());
    }
    @Test
    public void testSetAddressShouldAllowsToSetAPersonAddress()  {
        Person person = new Person("Melody", "Dooley", new Gender("Female"));
        Address address = new Address("West Shanna", "Vermont", "Bangladesh");
        person.setAddress(new Address("West Shanna", "Vermont", "Bangladesh"));
        assertEquals(address,person.getAddress());
    }



}
