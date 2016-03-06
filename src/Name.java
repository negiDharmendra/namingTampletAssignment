
public class Name {
    private final String firstName;
    private final String lastName;
    private NameFormatter nameFormatter;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String createFullName(Gender gender) {
        return gender.createHonorific()+" "+nameFormatter.formatt(firstName,lastName);
    }
    @Override
    public boolean equals(Object otherName) {
        if (this == otherName) return true;
        if (!(otherName instanceof Name)) return false;
        Name name = (Name) otherName;
        return firstName.equals(name.firstName)&&lastName.equals(name.lastName);
    }

    public void addNameFormatter(NameFormatter nameFormatter) {
        this.nameFormatter = nameFormatter;
    }
}
