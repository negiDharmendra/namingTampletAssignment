import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    @Test
    public void testDefaultFormatToAdressAMalePersonIsMrFirstNameSpaceLastName()  {
        Person person = new Person("Dharmendra", "Negi", new Gender("male"));
        assertEquals("Mr Dharmendra Negi",person.getInviteeDetails());
    }
    @Test
    public void testDefaultFormatToAdressAFemalePersonisMsFirstNameSpaceLastName()  {
        Person person = new Person("Cleve", "Raynor", new Gender("Female"));
        assertEquals("Ms Cleve Raynor",person.getInviteeDetails());
    }
    @Test
    public void testChangeTheFormatOfAddressingAPersonWillChangeFormatIfGivenValueISTrue()  {
        Person person = new Person("Dharmendra", "Negi", new Gender("male"));
        person.changeTheFormatOfAddressingAPerson(true);
        assertEquals("Mr Negi, Dharmendra",person.getInviteeDetails());
    }
    @Test
    public void testGetInviteeDetailsWIthCountryLabelGivesThePersonNameWithCountryName()  {
        Person person = new Person("Cleve", "Raynor", new Gender("Female"));
        person.setAddress(new Address("New Alanna","Georgia","Slovakia (Slovak Republic)"));
        assertEquals("Ms Cleve Raynor, Slovakia (Slovak Republic)",person.getInviteeDetailsWIthCountryLabel());
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
    @Test
    public void testAPersonShouldEqualsToItSelf()  {
        Person person = new Person("Melody", "Dooley", new Gender("Female"));
        person.setAge(45);
        person.setAddress(new Address("West Shanna", "Vermont", "Bangladesh"));
        assertEquals(person,person);
    }
    @Test
    public void testAPersonIsEqualsToOtherPersonWhenBothOfThemHaveExactlySameDetails()  {
        Person personOne = new Person("Melody", "Dooley", new Gender("Female"));
        personOne.setAge(45);
        personOne.setAddress(new Address("West Shanna", "Vermont", "Bangladesh"));

        Person personTwo = new Person("Melody", "Dooley", new Gender("Female"));
        personTwo.setAge(45);
        personTwo.setAddress(new Address("West Shanna", "Vermont", "Bangladesh"));
        assertEquals(personOne,personTwo);
    }
}
