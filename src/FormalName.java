public class FormalName implements NameFormatter {
    public FormalName() {
    }
    @Override
    public String formatt(String firstName, String lastName) {
       return  lastName+", "+firstName;
    }
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof FormalName);
    }

}
