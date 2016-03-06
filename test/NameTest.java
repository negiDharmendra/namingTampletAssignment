import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NameTest {
    @Test
    public void testGenerateFormalNameGiveNameAsLastNameCommaSpaceFirstName(){
        Name name = new Name("Vikash", "Upadhyay");
        name.addNameFormatter(new FormalName());
        assertEquals("Mr Upadhyay, Vikash",name.createFullName(new Gender("Male")));
    }
    @Test
    public void testGenerateInFormalNameGiveNameAsFirstNameSpaceFirstName(){
        Name name = new Name("Vikash", "Upadhyay");
        name.addNameFormatter(new InformalName());
        assertEquals("Mr Vikash Upadhyay",name.createFullName(new Gender("Male")));
    }
}