
public class Guest {
    private final Name name;
    private final Gender gender;
    private int age;
    private Address address;

    public Guest(Name name, Gender gender, int age, Address address) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
    }

    public String generateLevel() {
        return name.createFullName(gender);
    }
    @Override
    public boolean equals(Object otherPerson) {
        if (this == otherPerson) return true;
        if (!(otherPerson instanceof Guest)) return false;

        Guest guest = (Guest) otherPerson;
        boolean isNameMatches = false, isGenderMatches = false, isAddressMatches = false;
        if (age != guest.age) return false;
        if (name != null && name.equals(guest.name)) isNameMatches = true;
        if (gender != null && gender.equals(guest.gender)) isGenderMatches = true;
        if (address != null && address.equals(guest.address)) isAddressMatches = true;
        return isNameMatches && isGenderMatches && isAddressMatches;
    }

    public boolean isResidentOf(String country) {
        return address.isCountry(country);
    }

    public boolean isAgeAbove(int age) {
        return this.age>age;
    }

    public String getAge() {
        return String.valueOf(age);
    }
}
