
public class Person {
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private int age;
    private Address address;
    private String fullName;

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        fullName = gender.getPrefix()+" "+ firstName + " " + lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void changeTheFormatOfAddressingAPerson(boolean namingFormat) {
        if (namingFormat)
            fullName = gender.getPrefix()+" "+ lastName + ", " + firstName;
    }
    public String getInviteeDetails(){
        return fullName;
    }
    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name : " + fullName +
                ", Age : " + age +
                ", Address : \n\t" + address.toString();
    }


    public String getInviteeDetailsWIthCountryLabel() {
        return fullName + ", " + address.getCountryName();
    }

    @Override
    public boolean equals(Object otherPerson) {
        if (this == otherPerson) return true;
        if (!(otherPerson instanceof Person)) return false;

        Person person = (Person) otherPerson;
        boolean isFirstNameMatches=false,isLastNameMatches=false,isGenderMatches=false,isAddressMatches=false;
        if (age != person.age) return false;
        if (firstName != null && firstName.equals(person.firstName)) isFirstNameMatches =true;
        if (lastName != null && lastName.equals(person.lastName))  isLastNameMatches =true;
        if (gender != null && gender.equals(person.gender))  isGenderMatches =true;
        if (address != null && address.equals(person.address))  isAddressMatches =true;
        return isFirstNameMatches&&isLastNameMatches&&isGenderMatches&&isAddressMatches;
    }
}
