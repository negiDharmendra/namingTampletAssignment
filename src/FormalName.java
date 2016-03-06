public class FormalName implements NameFormatter {
    public FormalName() {
    }

    public String formatt(String firstName, String lastName) {
       return  lastName+", "+firstName;
    }
}
