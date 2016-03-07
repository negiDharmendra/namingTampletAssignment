public class InformalName implements NameFormatter {
    public InformalName() {
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof InformalName);
    }

    @Override
    public String formatt(String firstName, String lastName) {
        return firstName +" "+lastName;
    }

}
