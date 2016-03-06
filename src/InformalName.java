public class InformalName implements NameFormatter {
    public InformalName() {
    }

    public String formatt(String firstName, String lastName) {
        return firstName +" "+lastName;
    }
}
